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
	//@Column(name="KYS_ID")
    private Long id;
    private String kysymys;
	private boolean enabled;
	@OneToOne(cascade = CascadeType.ALL)
	private Tyyppi tyyppi;
	@ManyToMany(fetch=FetchType.LAZY)
    private List<Vastaus> vastauslista;


	protected Kysymys() {
		super();
	}

    public Kysymys(String kysymys) {
    	super();
    	this.kysymys = kysymys;
        this.enabled = true;
        this.vastauslista = new ArrayList<Vastaus>();
        this.setTyyppi(new Tyyppi());
    }
    public Kysymys(long id, String kysymys) {
    	super();
    	this.id=id;
    	this.kysymys = kysymys;
        this.enabled = true;
        this.vastauslista = new ArrayList<Vastaus>();
        this.setTyyppi(new Tyyppi());
    }

    public Kysymys(String kysymys, String tyyppistring, String[] vaihtoehdot) {
    	super();
    	this.kysymys = kysymys;
        this.enabled = true;
        this.vastauslista = new ArrayList<Vastaus>();
        this.tyyppi= new Tyyppi(tyyppistring, vaihtoehdot);
    }
    public Kysymys(String kysymys, List<Vastaus> vastauslista) {
        super();
    	this.kysymys = kysymys;
        this.enabled = true;
        this.vastauslista= vastauslista;
        this.setTyyppi(new Tyyppi());
    }
    public Kysymys(String kysymys, boolean enabled, Tyyppi tyyppi, List<Vastaus> vastauslista) {
		super();
		this.kysymys = kysymys;
		this.enabled = enabled;
		this.tyyppi = tyyppi;
		this.vastauslista = vastauslista;
	}
    public Kysymys(long id,String kysymys, Tyyppi tyyppi) {
		super();
		this.id=id;
		this.kysymys = kysymys;
		this.enabled = true;
		this.tyyppi = tyyppi;
		this.vastauslista = new ArrayList<Vastaus>();
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


    public Tyyppi getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(Tyyppi tyyppi) {
		this.tyyppi = tyyppi;
	}

	@Override
	public String toString() {
		return "Kysymys [id=" + id + ", kysymys=" + kysymys + ", enabled=" + enabled + ", tyyppi=" + tyyppi
				+ ", vastauslista=" + vastauslista + "]";
	}
  
}