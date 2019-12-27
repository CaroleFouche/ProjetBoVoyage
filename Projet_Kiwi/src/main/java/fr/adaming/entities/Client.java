package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "clients")
public class Client implements Serializable {
	// Declaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cl")
	private int id;
	private String login;
	private String mdp;
	//private String role;
	
	private String name;
	private int phone;
	private String mail;
	private int age;
	private int numCard;
	private boolean solvability;
	private Boolean active;

	// Transformation de l'association UML en Java
	@Embedded
	@Transient
	private Adresse adresse;
	
	
//	@ManyToOne
//	@JoinColumn(name="r_id", referencedColumnName="id_r")
//	private Role role;
	
	@OneToMany(mappedBy = "client")
	private List<Role> roles;

	// un client peut avoir n bookings
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private List<Booking> bookings;

	// un client peut avoir un seul dossier client
	@OneToOne
	@JoinColumn(name = "d_id", referencedColumnName = "id_d")
	private DossierClient dossierClient;
	

	// Constructeur
	public Client() {
		super();
	}


	public Client(String login, String mdp, String name, int phone, String mail, int age, int numCard,
			boolean solvability, Boolean active, Adresse adresse, List<Role> roles, List<Booking> bookings,
			DossierClient dossierClient) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.age = age;
		this.numCard = numCard;
		this.solvability = solvability;
		this.active = active;
		this.adresse = adresse;
		this.roles = roles;
		this.bookings = bookings;
		this.dossierClient = dossierClient;
	}

	public Client(int id, String login, String mdp, String name, int phone, String mail, int age, int numCard,
			boolean solvability, Boolean active, Adresse adresse, List<Role> roles, List<Booking> bookings,
			DossierClient dossierClient) {
		super();
		this.id = id;
		this.login = login;
		this.mdp = mdp;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.age = age;
		this.numCard = numCard;
		this.solvability = solvability;
		this.active = active;
		this.adresse = adresse;
		this.roles = roles;
		this.bookings = bookings;
		this.dossierClient = dossierClient;
	}

	// Getters et setters
	public int getNumCard() {
		return numCard;
	}

	public void setNumCard(int numCard) {
		this.numCard = numCard;
	}

	public boolean isSolvability() {
		return solvability;
	}

	public void setSolvability(boolean solvability) {
		this.solvability = solvability;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public DossierClient getDossierClient() {
		return dossierClient;
	}

	public void setDossierClient(DossierClient dossierClient) {
		this.dossierClient = dossierClient;
	}

	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

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

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", login=" + login + ", mdp=" + mdp + ", name=" + name + ", phone=" + phone
				+ ", mail=" + mail + ", age=" + age + ", numCard=" + numCard + ", solvability=" + solvability
				+ ", active=" + active + ", adresse=" + adresse + ", dossierClient=" + dossierClient
				+ "]";
	}

}
