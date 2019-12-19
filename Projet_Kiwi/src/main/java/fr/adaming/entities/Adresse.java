package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse implements Serializable {
	//Declaration des attributs
	private int num;
	private String street;
	private int PostCode;
	private String city;
	
	
	//Constructeurs 
	public Adresse() {
		super();
	}

	public Adresse(int num, String street, int postCode, String city) {
		super();
		this.num = num;
		this.street = street;
		PostCode = postCode;
		this.city = city;
	}

	//Getters et setters
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getPostCode() {
		return PostCode;
	}

	public void setPostCode(int postCode) {
		PostCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Adresse [num=" + num + ", street=" + street + ", PostCode=" + PostCode + ", city=" + city + "]";
	}
	
	
	
	
}
