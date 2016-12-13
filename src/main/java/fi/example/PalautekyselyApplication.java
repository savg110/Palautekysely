package fi.example;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import fi.example.entity.Kysymys;
import fi.example.entity.KysymysCRUDRepo;
import fi.example.entity.Tyyppi;
import fi.example.entity.Vastaus;
import fi.example.entity.VastausCRUDRepo;
import fi.example.entity.Kysely;
import fi.example.entity.KyselyCRUDRepo;

@SpringBootApplication
public class PalautekyselyApplication {



	public static void main(String[] args) {
		SpringApplication.run(PalautekyselyApplication.class);
	}

	@Bean
	public CommandLineRunner demo(KyselyCRUDRepo kyselyrepo, KysymysCRUDRepo repository, VastausCRUDRepo vasrepo) {
		return (args) -> {
			
			//tallennetaan 3 vastausta
			Kysely kysely1=new Kysely("ensimmäinen kysely","lisätiedot", new ArrayList<Kysymys>());
			
			kyselyrepo.save(kysely1);
			kyselyrepo.save(new Kysely("toinen kysely","lisätiedot 2", new ArrayList<Kysymys>()));
			/*Vastaus vastaus1 = new Vastaus("Vastaus___1");
			Vastaus vastaus2 = new Vastaus("Vastaus___2");
			Vastaus vastaus3 = new Vastaus("Vastaus3");
			Vastaus vastaus4 = new Vastaus("myöhemmin lisättävä vastaus");
			

			//luodaan 3 kysymystä
			Kysymys kysymys1 = new Kysymys("Toimiiko?");
			Kysymys kysymys2 = new Kysymys("Uuusi Kysymys?");
			Kysymys kysymys3 = new Kysymys("Kolmas kysymys?");
			kysymys1.setKysely(kysely1);
			kysymys2.setKysely(kysely2);
			kysymys3.setKysely(kysely1);
			

			//liitetään vastaus 1 kysymys3:een
			kysymys1.getVastauslista().add(vastaus1);
			//kysymys3.setTyyppi("radio");
			//liitetään vastaus 1 kysymys 1:een
			kysymys2.getVastauslista().add(vastaus2);

			//tallennetaan vastaus 3 kysymys 3:een
			kysymys3.getVastauslista().add(vastaus3);

			
			String[] jeejjee={"hyvin","huonosti","vähän","paljon"};
			Tyyppi tyyppi2 = new Tyyppi("checkbox",jeejjee); 
			Tyyppi tyyppi3 = new Tyyppi(); 
			kysymys1.setTyyppi(tyyppi2);
			
			kysymys3.setTyyppi(tyyppi3);
			Tyyppi tyyppi1= new Tyyppi("radio",jeejjee);
			kysymys2.setTyyppi(tyyppi1);
			//liitetään vastaus 4 kysymys 1:een
			kysymys1.getVastauslista().add(vastaus4);
			//liitetään vastaus 2 kysymys 3:een
			kysymys3.getVastauslista().add(vastaus2);	
			
			kysely1.getKysymyslista().add(kysymys1);
			kysely2.getKysymyslista().add(kysymys2);
			kysely2.getKysymyslista().add(kysymys3);
			vasrepo.save(vastaus1);
			vasrepo.save(vastaus2);
			vasrepo.save(vastaus3);
			vasrepo.save(vastaus4);
			repository.save(kysymys1);
			repository.save(kysymys2);
			repository.save(kysymys3);
			kyselyrepo.save(kysely1);
			kyselyrepo.save(kysely2);
		*/
		};
	
		}
	}
