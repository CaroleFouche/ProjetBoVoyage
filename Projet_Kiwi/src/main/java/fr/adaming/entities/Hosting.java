package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="hostings")
public class Hosting implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_h")
	private int id;

	private String name;

	private Date arrivalDate;

	private Date leavingDate;

	private String city;

	private Prestation presta;
	
	
	//Transfo l'association UML en Java
	@ManyToOne
	@JoinColumn(name="t_id",referencedColumnName="id_t")
	private Travel travel;
	

	public Hosting(int id, String name, Date arrivalDate, Date leavingDate, String city, Prestation presta) {
		super();
		this.id = id;
		this.name = name;
		this.arrivalDate = arrivalDate;
		this.leavingDate = leavingDate;
		this.city = city;
		this.presta = presta;
	}

	public Hosting(String name, Date arrivalDate, Date leavingDate, String city, Prestation presta) {
		super();
		this.name = name;
		this.arrivalDate = arrivalDate;
		this.leavingDate = leavingDate;
		this.city = city;
		this.presta = presta;
	}

	public Hosting() {
		super();
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
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

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Prestation getPresta() {
		return presta;
	}

	public void setPresta(Prestation presta) {
		this.presta = presta;
	}

	@Override
	public String toString() {
		return "Hosting [id=" + id + ", name=" + name + ", arrivalDate=" + arrivalDate + ", leavingDate=" + leavingDate
				+ ", city=" + city + ", presta=" + presta + "]";
	}

}
