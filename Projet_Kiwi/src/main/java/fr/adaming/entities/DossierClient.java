package fr.adaming.entities;

import java.io.Serializable;

public class DossierClient implements Serializable {
	
	//Declaration des attributs
	private int id;

	public DossierClient(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
