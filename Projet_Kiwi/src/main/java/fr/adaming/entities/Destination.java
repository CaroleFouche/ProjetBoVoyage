package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name="destinations")
public class Destination implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_d")
	private int id;

	private String pays;

	private String continent;
	
	//Transfo de l'association UML en Java
	@OneToOne(mappedBy="destination")
	private Travel travel;

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

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	@Override
	public String toString() {
		return "Destination [id=" + id + ", pays=" + pays + ", continent=" + continent + "]";
	}

}
