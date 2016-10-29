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
			
			vasrepo.save(new Vastaus("Vastaus___1"));
			vasrepo.save(new Vastaus("Vastaus___2"));
			
			Vastaus vastaus = vasrepo.findOne(1L);
			Kysymys kysymys = new Kysymys("Toimiiko?");
			Kysymys kysymys2 = new Kysymys("Uuusi Kysymys?");
			kysymys.getVastauslista().add(vastaus);
			vastaus = vasrepo.findOne(2L);
			kysymys2.getVastauslista().add(vastaus);
			repository.save(kysymys2);
			kysymys.getVastauslista().add(vastaus);
			repository.save(kysymys);


			repository.save(kysymys);
			

			
		
		};
	
		}
	}
