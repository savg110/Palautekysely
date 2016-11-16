package fi.example.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Kysymys implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5186081615228513721L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="KYS_ID")
    private Long id;
    private String kysymys;
	private boolean enabled;
	private String tyyppi;
	@ManyToMany(fetch=FetchType.LAZY)
    private List<Vastaus> vastauslista;

    protected Kysymys() {}

    public Kysymys(String kysymys) {
        this.kysymys = kysymys;
        this.enabled = true;
        this.vastauslista = new ArrayList<Vastaus>();
    }
    public Kysymys(String kysymys, List<Vastaus> vastauslista) {
        this.kysymys = kysymys;
        this.enabled = true;
        this.vastauslista= vastauslista;
    }
    
    public Long getId() {
		return id;
	}

	public String getKysymys() {
		return kysymys;
	}
	
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}

	public List<Vastaus> getVastauslista() {
		return vastauslista;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

	public void setVastauslista(List<Vastaus> vastauslista) {
		this.vastauslista = vastauslista;
	}


    @Override
    public String toString() {
        return String.format(
                "Kysymys[id=%d, kysymys='%s', lista='%s']",
                id, kysymys,vastauslista);
    }



}