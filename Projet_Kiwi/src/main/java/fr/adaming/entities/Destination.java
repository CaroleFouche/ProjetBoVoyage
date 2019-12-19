package fr.adaming.entities;

import java.io.Serializable;

public class Destination implements Serializable {

	private int id;

	private String pays;

	private String continent;

	public Destination(int id, String pays, String continent) {
		super();
		this.id = id;
		this.pays = pays;
		this.continent = continent;
	}

	public Destination(String pays, String continent) {
		super();
		this.pays = pays;
		this.continent = continent;
	}

	public Destination() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	@Override
	public String toString() {
		return "Destination [id=" + id + ", pays=" + pays + ", continent=" + continent + "]";
	}

}
