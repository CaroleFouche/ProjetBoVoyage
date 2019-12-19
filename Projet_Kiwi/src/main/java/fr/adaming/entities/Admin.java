package fr.adaming.entities;

import java.io.Serializable;

public class Admin implements Serializable {

	//Declaration des attributs 
	private int id;
	private String login;
	private String mdp;
	
	//COnstructeur
	public Admin() {
		super();
	}
	public Admin(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}
	public Admin(int id, String login, String mdp) {
		super();
		this.id = id;
		this.login = login;
		this.mdp = mdp;
	}
	
	//Getters et setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", mdp=" + mdp + "]";
	}
	
	
}
