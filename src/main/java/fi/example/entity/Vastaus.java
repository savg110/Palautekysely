package fi.example.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Vastaus implements Serializable {
	private static final long serialVersionUID = -3190676321479581507L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Size(min = 1, max = 30)
	private String vastaus;

	public Vastaus() {
		super();
	}

	public Vastaus(String vastaus) {
		super();
		this.vastaus = vastaus;
	}

	public long getId() {
		return id;
	}

	public String getVastaus() {
		return vastaus;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}

	@Override
	public String toString() {
		return "Vastaus [id=" + id + ", vastaus=" + vastaus + "]";
	}

}
