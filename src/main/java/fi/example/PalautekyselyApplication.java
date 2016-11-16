package fi.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import fi.example.entity.Kysymys;
import fi.example.entity.KysymysCRUDRepo;
import fi.example.entity.Vastaus;
import fi.example.entity.VastausCRUDRepo;

@SpringBootApplication
public class PalautekyselyApplication {



	public static void main(String[] args) {
		SpringApplication.run(PalautekyselyApplication.class);
	}

	@Bean
	public CommandLineRunner demo(KysymysCRUDRepo repository, VastausCRUDRepo vasrepo) {
		return (args) -> {
			// save a couple of customers
			//tallennetaan 3 vastausta
			vasrepo.save(new Vastaus("Vastaus___1"));
			vasrepo.save(new Vastaus("Vastaus___2"));
			vasrepo.save(new Vastaus("Vastaus3"));
			//etsitään vastaus 1
			Vastaus vastaus = vasrepo.findOne(1L);
			//luodaan 3 kysymystä
			Kysymys kysymys = new Kysymys("Toimiiko?");
			Kysymys kysymys2 = new Kysymys("Uuusi Kysymys?");
			Kysymys kysymys3 = new Kysymys("Kolmas kysymys?");
			//liitetään vastaus 1 kysymys3:een
			kysymys3.getVastauslista().add(vastaus);
			//liitetään vastaus 1 kysymys 1:een
			kysymys.getVastauslista().add(vastaus);
			//etsitään vastaus 2
			vastaus = vasrepo.findOne(2L);
			//tallennetaan vastaus 2 kysymys 2:een
			kysymys2.getVastauslista().add(vastaus);
			//tallennetaan kysymys2 tietokantaan
			repository.save(kysymys2);
			//liitetään vastaus 2 kysymys 1:een
			kysymys.getVastauslista().add(vastaus);
			//liitetään vastaus 2 kysymys 3:een
			kysymys3.getVastauslista().add(vastaus);
			
			repository.save(kysymys);


			repository.save(kysymys3);
			

			
		
		};
	
		}
	}
