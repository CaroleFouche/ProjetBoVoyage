package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class Booking implements Serializable {
	
	//Declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_b")
	private int id;
	private Status status;
	private boolean assurance;
	
	//Transfo assoc UML en Java
	@OneToOne(mappedBy="booking")
	private Travel travel;
	
	@OneToMany(mappedBy="booking")
	private List<Traveller> travellers;
	
	@OneToOne(mappedBy="booking")
	private Client client;
	
	
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
		this.travellers = travellers;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", status=" + status + ", assurance=" + assurance + "]";
	}
	
	
	
}
