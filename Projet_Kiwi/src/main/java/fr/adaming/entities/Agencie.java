package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "agencies")
public class Agencie implements Serializable {

	// Declaration des attributs
	@Id
	@GeneratedValue
	@Column(name = "id_ag")
	private int id;
	private String name;
	private String localisation;
	private int PhoneNumber;

	
	//transformation de l'association UML en Java
	@OneToMany(mappedBy="agencie")
	private List<Admin> listAdmin;
	
	
	// Constructeurs
	public Agencie() {
		super();
	}

	public Agencie(String name, String localisation, int phoneNumber) {
		super();
		this.name = name;
		this.localisation = localisation;
		PhoneNumber = phoneNumber;
	}

	public Agencie(int id, String name, String localisation, int phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.localisation = localisation;
		PhoneNumber = phoneNumber;
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

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public int getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	public List<Admin> getListAdmin() {
		return listAdmin;
	}

	public void setListAdmin(List<Admin> listAdmin) {
		this.listAdmin = listAdmin;
	}

	@Override
	public String toString() {
		return "Agence [id=" + id + ", name=" + name + ", localisation=" + localisation + ", PhoneNumber=" + PhoneNumber
				+ "]";
	}
	
	

}
