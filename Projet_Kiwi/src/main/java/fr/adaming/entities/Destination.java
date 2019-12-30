package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "destinations")
public class Destination implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_d")
	private int id;

	private String pays;

	private String continent;

	@OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Image> pics;

	// Transfo de l'association UML en Java
	@OneToMany(mappedBy = "destination")
	private List<Travel> listTravel;

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

	public List<Travel> getListTravel() {
		return listTravel;
	}

	public void setListTravel(List<Travel> listTravel) {
		this.listTravel = listTravel;
	}

	public List<Image> getPics() {
		return pics;
	}

	public void setPics(List<Image> pics) {
		this.pics = pics;
	}

	@Override
	public String toString() {
		return "Destination [id=" + id + ", pays=" + pays + ", continent=" + continent + "]";
	}

}
