package fr.adaming.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "bookings")
public class Booking implements Serializable {

	// Declaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_b")
	private int id;
	private Status status;
	private boolean assurance;
	private Formula formula;
	private int nbTravellers;

	// Un booking a un seul voyage
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "t_id", referencedColumnName = "id_t")
	private Travel travel;

	// Un booking peut avoir n travellers
	@OneToMany(mappedBy = "booking", cascade=CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Traveller> travellers;

	// Un booking a un seul client (qui a plusieurs bookings)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cl_id", referencedColumnName = "id_cl")
	private Client client;

	// Constructeurs
	public Booking() {
		super();
		this.travellers = new ArrayList<Traveller>();
		this.travellers.add(new Traveller());
		this.nbTravellers = this.travellers.size();
	}

	public Booking(Status status, boolean assurance, Formula formule) {
		super();
		this.status = status;
		this.assurance = assurance;
		this.formula=formule;
	}

	public Booking(int id, Status status, boolean assurance) {
		super();
		this.id = id;
		this.status = status;
		this.assurance = assurance;
	}

	// Getters et setters
	public int getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
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

	public List<Traveller> getTravellers() {
		return travellers;
	}

	public void setTravellers(List<Traveller> travellers) {
		this.travellers.clear();
		this.travellers.addAll(travellers);
	}

	public Formula getFormula() {
		return formula;
	}

	public void setFormula(Formula formula) {
		this.formula = formula;
	}
	
	public int getNbTravellers() {
		return nbTravellers;
	}

	public void setNbTravellers(int nbTravellers) {
		this.nbTravellers = nbTravellers;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", status=" + status + ", assurance=" + assurance + ", formula=" + formula
				+ ", travel=" + travel + ", travellers=" + travellers + ", client=" + client + "]";
	}

}
