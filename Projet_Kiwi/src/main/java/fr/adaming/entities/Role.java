package fr.adaming.entities;

import java.io.Serializable;

public class Role implements Serializable {
	//Declaration des attributs
	private int id;
	private String name;
	private boolean active;


	//Constructeurs
	public Role() {
		super();
	}

	public Role(String name, boolean active) {
		super();
		this.name = name;
		this.active = active;
	}

	public Role(int id, String name, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
	}

	//Getters et setters
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", active=" + active + "]";
	}
	
	
	
	
}
