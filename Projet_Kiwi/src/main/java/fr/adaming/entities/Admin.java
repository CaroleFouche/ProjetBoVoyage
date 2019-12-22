package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin implements Serializable {

	// Declaration des attributs
	@Id
	@GeneratedValue
	@Column(name = "id_a")
	private int id;
	private String login;
	private String mdp;
	private Boolean active;

	// Transformation de l'association UML en JAVA

	@ManyToOne
	@JoinColumn(name = "r_id", referencedColumnName = "id_r")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name="ag_id", referencedColumnName="id_ag")
	private Agencie agencie;
	

	// Constructeur
	public Admin() {
		super();
	}

	public Admin(String login, String mdp, boolean active) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.active = active;
	}

	public Admin(int id, String login, String mdp, boolean active) {
		super();
		this.id = id;
		this.login = login;
		this.mdp = mdp;
		this.active = active;
	}

	// Getters et setters
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	public Agencie getAgencie() {
		return agencie;
	}

	public void setAgencie(Agencie agencie) {
		this.agencie = agencie;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", mdp=" + mdp + ", active=" + active + "]";
	}

}
