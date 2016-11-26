package fi.example.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Kysely implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2380030494179285503L;
	/**
	 * 
	 */
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name="KYSELY_ID")
    private Long id;
	private String nimi;
	private String info;
	@ManyToMany(fetch=FetchType.LAZY)
    private List<Kysymys> kysymyslista;
	
	public Kysely() {
		super();
	}
	
	public Kysely(String nimi, String info, List<Kysymys> kysymyslista) {
		super();
		this.nimi = nimi;
		this.info = info;
		this.kysymyslista = kysymyslista;
	}
	public Kysely(String nimi, String info) {
		super();
		this.nimi = nimi;
		this.info = info;
		this.kysymyslista = new ArrayList<Kysymys>();
	}
	
	public Long getId() {
		return id;
	}
	public String getNimi() {
		return nimi;
	}
	public String getInfo() {
		return info;
	}
	public List<Kysymys> getKysymyslista() {
		return kysymyslista;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public void setKysymyslista(List<Kysymys> kysymyslista) {
		this.kysymyslista = kysymyslista;
	}
	@Override
	public String toString() {
		return "Kysely [id=" + id + ", nimi=" + nimi + ", info=" + info + ", kysymyslista=" + kysymyslista + "]";
	}
}
