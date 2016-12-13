package fi.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.example.entity.Kysely;
import fi.example.entity.KyselyCRUDRepo;
import fi.example.entity.Kysymys;
import fi.example.entity.KysymysCRUDRepo;
import fi.example.entity.Vastaus;
import fi.example.entity.VastausCRUDRepo;


@CrossOrigin
@Secured("ROLE_ADMIN")
@RestController


public class FromController {
	@Autowired
	KysymysCRUDRepo kysrepo;
	@Autowired
	VastausCRUDRepo vasrepo;
	@Autowired
	KyselyCRUDRepo kyselyrepo;
	
	@GetMapping (value = "lomakejson/kysymyslista")
	public List<Kysymys> haeKysymyksetJSON() {
		System.out.println(kysrepo.findAll());
		 return (List<Kysymys>) kysrepo.findAll();
	}
	@GetMapping (value = "lomakejson/kyselylista")
	public List<Kysely> haeKyselytJSON() {
		System.out.println(kyselyrepo.findAll());
		 return (List<Kysely>) kyselyrepo.findAll();
	}
	@GetMapping("kysymys/{id}")
	public Kysymys kysymys( @PathVariable long id) {	
		Kysymys kys =  kysrepo.findOne(id);
		List<Vastaus> lista = new ArrayList<Vastaus>();
		kys.setVastauslista(lista);
		return kys;
	}
	@GetMapping("kysely/{id}")
	public Kysely Kysely( @PathVariable long id) {	
		Kysely kysely =  kyselyrepo.findOne(id);
		List<Kysymys> kysymyslista=kysely.getKysymyslista();
		List<Vastaus> tyhjalista= new ArrayList<Vastaus>();
		for (Kysymys kysymys : kysymyslista){
			kysymys.setVastauslista(tyhjalista);
		}
		kysely.setKysymyslista(kysymyslista);
		return kysely;
	}
	
	@PostMapping("tallenna")
	public String tallenna( @RequestBody List<Vastaus> vastauslista) { 
			System.out.println("vastausta tuli: "+vastauslista);
			for (Vastaus vastaus : vastauslista){
				Kysymys kys = kysrepo.findOne(vastaus.getId());
				vastaus.setId(0L);			
				kys.getVastauslista().add(vastaus);
				vasrepo.save(vastaus);
			}			
			return "200";
		}
	@PostMapping("poistakysymys")
	public String poistakysymys( @RequestBody Kysely kysely ) {	
		kyselyrepo.save(kysely);
		return "200";
	}
	@PostMapping("poistavastaus")
	public String poistavastaus( @RequestBody Vastaus id ) {
		System.out.println("poistettavan id: "+id);
		vasrepo.delete(id);
		return "200";
	}
	@PostMapping("poistakysely")
	public String poistakysely( @RequestBody long id ) {
		System.out.println("poistettavan id: "+id);
		kyselyrepo.delete(id);
		return "200";
	}
	
	@PostMapping("lisaakysymys")
	public String lisaakysymys( @RequestBody List<Kysymys> kysymys ) {
		Kysely kysely = kyselyrepo.findOne(kysymys.get(0).getId());
		kysely.getKysymyslista().add(kysymys.get(1));
		kysrepo.save(kysymys.get(1));
						
		return "200";
	}
	@PostMapping("lisaakysely")
	public String lisaakysymys( @RequestBody Kysely kysely ) {
		kyselyrepo.save(kysely);		
		return "200";
	}
	

}