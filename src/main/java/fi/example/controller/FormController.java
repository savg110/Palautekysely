package fi.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.example.entity.Kysymys;
import fi.example.entity.KysymysCRUDRepo;
import fi.example.entity.Vastaus;
import fi.example.entity.VastausCRUDRepo;




@RestController
public class FormController {
	@Autowired
	KysymysCRUDRepo kysrepo;
	@Autowired
	VastausCRUDRepo vasrepo;
	
	@GetMapping("get.json")
	public List<Kysymys> haeKysymyksetJSON() {
		System.out.println(kysrepo.findAll());
		 return (List<Kysymys>) kysrepo.findAll();
	}
	@PostMapping("tallenna")
	public String tallenna( @RequestBody List<Vastaus> vastauslista) { 
		
			
			System.out.println("vastausta tuli: "+vastauslista);
			for (Vastaus vastaus : vastauslista){
				
				Kysymys kys = kysrepo.findOne(vastaus.getId());
				vastaus.setId(0L);
				vasrepo.save(vastaus);
				kys.getVastauslista().add(vastaus);
				kysrepo.save(kys);
			}
			
			return "200";
		}
	@PostMapping("poistakysymys")
	public String poistakysymys( @RequestBody long id ) {
		System.out.println("poistettavan id: "+id);
		
		// tähän jotain joka toimii
		kysrepo.delete(id);
		
		return "200";
	}
	@PostMapping("lisaakysymys")
	public String lisaakysymys( @RequestBody Kysymys kysymys ) {

		kysrepo.save(kysymys);
		
		return "200";
	}
}