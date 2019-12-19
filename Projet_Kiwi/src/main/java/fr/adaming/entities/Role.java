package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable {
	// Declaration des attributs
	private int id;
	private String name;

	// Transformation de l'association UML en JAVA
	@OneToMany(mappedBy="role")	
	private List<Admin> admins;

	@OneToMany(mappedBy="role")
	private List<Client> clients;

	// Constructeurs
	public Role() {
		super();
	}

	public Role(String name) {
		super();
		this.name = name;

	}

	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;

	}

	// Getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + " ]";
	}

}
