package fr.adaming.entities;

import java.io.Serializable;

public class Car implements Serializable {

	private int id;

	private String loueur;

	private Category cat;

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
