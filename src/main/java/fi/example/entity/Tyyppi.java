package fi.example.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Tyyppi implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3190676321479581507L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private String tyyppi;
	private String[] vaihtoehdot={};
	

	public Tyyppi(){
		this.tyyppi="text";	
	}
	public Tyyppi(String tyyppi, String[] vaihtoehdot){
		this.tyyppi=tyyppi;
		this.vaihtoehdot=vaihtoehdot;
	}
	
	
	public long getId() {
		return id;
	}
	
	public String getTyyppi() {
		return tyyppi;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}
	public String[] getVaihtoehdot() {
		return vaihtoehdot;
	}


	public void setVaihtoehdot(String[] vaihtoehdot) {
		this.vaihtoehdot = vaihtoehdot;
	}
	@Override
	public String toString() {
		return "Tyyppi [id=" + id + ", tyyppi=" + tyyppi + "]";
	}
	
	
}
