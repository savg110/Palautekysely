package fi.example;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.example.entity.Kysely;
import fi.example.entity.KyselyCRUDRepo;
import fi.example.entity.Kysymys;
import fi.example.entity.KysymysCRUDRepo;
import fi.example.entity.Vastaus;
import fi.example.entity.VastausCRUDRepo;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class PalautekyselyApplicationTests {
//
//	@Test
//	public void contextLoads() {
//	}
//
//}

@RunWith(SpringRunner.class)
@SpringBootTest
public class PalautekyselyApplicationTests {

    private VastausCRUDRepo vastausrepo;
	
    @Autowired
    public void setVastausrepo(VastausCRUDRepo vastausrepo) {
        this.vastausrepo = vastausrepo;
    }

    private KysymysCRUDRepo kysymysrepo;

    @Autowired
    public void setKysymysrepo(KysymysCRUDRepo kysymysrepo) {
        this.kysymysrepo = kysymysrepo;
    }
    
	private KyselyCRUDRepo kyselyrepo;

    @Autowired
    public void setKyselyrepo(KyselyCRUDRepo kyselyrepo) {
        this.kyselyrepo = kyselyrepo;
    }

    private Vastaus vastaus;
    private Kysymys kysymys;
    private Kysely kysely;
    
	@Test
    public void lisaaVastaus() {
    	vastaus = new Vastaus("testivastaus");

    	assertNull(vastaus.getId());
    	vastausrepo.save(vastaus);
    	assertNotNull(vastaus.getId());
    }
    
    @Test
    public void lisaaKysymys() {
    	List<Vastaus> vastauslista = new ArrayList<>();
    	vastauslista.add(vastaus);
    	kysymys = new Kysymys("testikysymys", vastauslista);

    	assertNull(kysymys.getId());
    	kysymysrepo.save(kysymys);
    	assertNotNull(kysymys.getId());
    }
    
    @Test
    public void lisaaKysely() {
    	List<Kysymys> kysymyslista = new ArrayList<>();
    	kysymyslista.add(kysymys);
    	kysely = new Kysely("testikysely", "testikyselyn info", kysymyslista);

    	assertNull(kysely.getId());
    	kyselyrepo.save(kysely);
    	assertNotNull(kysely.getId());
    }
}