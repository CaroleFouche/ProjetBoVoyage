package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "travellers")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typePersonne") //pour faire la diff entre les travellers et les clients
@DiscriminatorValue("trav")
public class Traveller implements Serializable {

	// Declaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tr")
	protected int id;
	protected String name;
	protected int phone;
	protected String mail;
	protected int age;

	// Transfo de l'assoc UML en Java
	@ManyToOne
	@JoinColumn(name = "b_id", referencedColumnName = "id_b")
	protected Booking booking;

	// Constructeurs
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

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Traveller [id=" + id + ", name=" + name + ", phone=" + phone + ", mail=" + mail + ", age=" + age + "]";
	}

}
