package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends Traveller implements Serializable {
	// Declaration des attributs
	private int numCard;
	private boolean solvability;
	private String login;
	private String mdp;
	private Boolean active;

	// Transformation de l'association UML en Java
	@Embedded
	private Adresse adresse;

	@OneToOne
	@JoinColumn(name = "b_id", referencedColumnName = "id_b")
	private Booking booking;

	@OneToOne
	@JoinColumn(name = "d_id", referencedColumnName = "id_d")
	private DossierClient dossierClient;

	@ManyToOne
	@JoinColumn(name = "r_id", referencedColumnName = "id_r")
	private Role role;

	// Constructeur

	public Client() {
		super();
	}

	public Client(String name, int phone, String mail, int age, int numCard, boolean solvability, String login,
			String mdp, boolean active) {
		super(name, phone, mail, age);
		this.numCard = numCard;
		this.solvability = solvability;
		this.login = login;
		this.mdp = mdp;
		this.active = active;
	}

	public Client(int id, String name, int phone, String mail, int age, int numCard, boolean solvability, String login,
			String mdp, boolean active) {
		super(id, name, phone, mail, age);
		this.numCard = numCard;
		this.solvability = solvability;
		this.login = login;
		this.mdp = mdp;
		this.active = active;
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

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public DossierClient getDossierClient() {
		return dossierClient;
	}

	public void setDossierClient(DossierClient dossierClient) {
		this.dossierClient = dossierClient;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Client [numCard=" + numCard + ", solvability=" + solvability + ", login=" + login + ", mdp=" + mdp
				+ ", adresse=" + adresse + "]";
	}

}
