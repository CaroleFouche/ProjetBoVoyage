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
@Table(name="cars")
public class Car implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_c")
	private int id;

	private String loueur;

	private Category cat;
	
	//Transfo de l'asso UML en JAva
	@OneToOne(mappedBy="car")
	private Travel travel;

	
	public Car(int id, String loueur, Category cat) {
		super();
		this.id = id;
		this.loueur = loueur;
		this.cat = cat;
	}

	public Car(String loueur, Category cat) {
		super();
		this.loueur = loueur;
		this.cat = cat;
	}

	public Car() {
		super();
	}


	
	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoueur() {
		return loueur;
	}

	public void setLoueur(String loueur) {
		this.loueur = loueur;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", loueur=" + loueur + ", cat=" + cat + "]";
	}

}
