package fr.adaming.entities;

import java.io.Serializable;

public class Traveller implements Serializable {

	//Declaration des attributs
	protected int id;
	protected String name; 
	protected int phone;
	protected String mail;
	protected int age;
	
	//Constructeurs
	public Traveller() {
		super();
	}

	public Traveller(String name, int phone, String mail, int age) {
		super();
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.age = age;
	}

	public Traveller(int id, String name, int phone, String mail, int age) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.age = age;
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Traveller [id=" + id + ", name=" + name + ", phone=" + phone + ", mail=" + mail + ", age=" + age + "]";
	}
	
	
}
