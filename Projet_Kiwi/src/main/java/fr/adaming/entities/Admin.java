package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	//private String role;
	private Boolean active;

//	@ManyToOne
//	@JoinColumn(name="r_id", referencedColumnName="id_r")
//	private Role role;
	
	@OneToMany(mappedBy = "admin")
	private List<Role> roles;
	
	
	@ManyToOne
	@JoinColumn(name="ag_id", referencedColumnName="id_ag")
	private Agencie agencie;
	

	// Constructeur
	public Admin() {
		super();
	}

	public Admin(String login, String mdp, Boolean active, List<Role> roles, Agencie agencie) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.active = active;
		this.roles = roles;
		this.agencie = agencie;
	}

	public Admin(int id, String login, String mdp, Boolean active, List<Role> roles, Agencie agencie) {
		super();
		this.id = id;
		this.login = login;
		this.mdp = mdp;
		this.active = active;
		this.roles = roles;
		this.agencie = agencie;
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
	
	

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Agencie getAgencie() {
		return agencie;
	}

	public void setAgencie(Agencie agencie) {
		this.agencie = agencie;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", mdp=" + mdp + ", role=" + roles + ", active=" + active
				+ ", agencie=" + agencie + "]";
	}



}
