package fr.adaming.entities;

import java.io.Serializable;

public class Booking implements Serializable {
	
	//Declaration des attributs
	private int id;
	private Status status;
	private boolean assurance;
	
	//Constructeurs
	public Booking() {
		super();
	}

	public Booking(Status status, boolean assurance) {
		super();
		this.status = status;
		this.assurance = assurance;
	}

	public Booking(int id, Status status, boolean assurance) {
		super();
		this.id = id;
		this.status = status;
		this.assurance = assurance;
	}

	//Getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isAssurance() {
		return assurance;
	}

	public void setAssurance(boolean assurance) {
		this.assurance = assurance;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", status=" + status + ", assurance=" + assurance + "]";
	}
	
	
	
}
