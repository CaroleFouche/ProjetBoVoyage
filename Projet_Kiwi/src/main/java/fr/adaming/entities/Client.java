package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Embedded;

public class Client extends Traveller implements Serializable  {
	//Declaration des attributs
	private int numCard;
	private boolean solvability;
	private String login;
	private String mdp;
	
	//Transformation de l'association UML en Java
	@Embedded
	private Adresse adresse;

	//Constructeur

	public Client() {
		super();
	}
	
	public Client(String name, int phone, String mail, int age, int numCard, boolean solvability, String login,
			String mdp) {
		super(name, phone, mail, age);
		this.numCard = numCard;
		this.solvability = solvability;
		this.login = login;
		this.mdp = mdp;
	}
	
	

	public Client(int id, String name, int phone, String mail, int age, int numCard, boolean solvability, String login,
			String mdp) {
		super(id, name, phone, mail, age);
		this.numCard = numCard;
		this.solvability = solvability;
		this.login = login;
		this.mdp = mdp;
	}

	//Getters et setters
	public int getNumCard() {
		return numCard;
	}

	public void setNumCard(int numCard) {
		this.numCard = numCard;
	}

	public boolean isSolvability() {
		return solvability;
	}

	public void setSolvability(boolean solvability) {
		this.solvability = solvability;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Client [numCard=" + numCard + ", solvability=" + solvability + ", login=" + login + ", mdp=" + mdp
				+ ", adresse=" + adresse + "]";
	}

	
	
}
