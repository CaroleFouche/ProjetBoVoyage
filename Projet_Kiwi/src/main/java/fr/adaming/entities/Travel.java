package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="travels")
public class Travel implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_t")
	private int id;

	private Date startDate;

	private Date endDate;

	private boolean availability;

	private double price;
	
	//Un voyage peut avoir plusieurs reservations de clients différents
	@OneToMany(mappedBy="travel")
	private List<Booking> bookings;
	
	//Un voyage a une seule destination
	@ManyToOne
	@JoinColumn(name="d_id", referencedColumnName= "id_d")
	private Destination destination;
	
	//Un voyage a une seule voiture
	@OneToOne
	@JoinColumn(name="c_id", referencedColumnName= "id_c")
	private Car car;
	
	//Un voyage peut avoir plusieurs acceuils
	@OneToMany(mappedBy="travel")
	private List<Hosting> hostings;
	

	public Travel(int id, Date startDate, Date endDate, boolean availability, double price) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.availability = availability;
		this.price = price;
	}

	public Travel( Date startDate, Date endDate, boolean availability, double price) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.availability = availability;
		this.price = price;
		
	}

	public Travel(Date startDate, Date endDate, boolean availability, double price, Destination destination) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.availability = availability;
		this.price = price;
		this.destination = destination;
	}

	public Travel() {
		super();
	}
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}



	public List<Hosting> getHostings() {
		return hostings;
	}

	public void setHostings(List<Hosting> hostings) {
		this.hostings = hostings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Travel [id=" + id +  ", startDate=" + startDate + ", endDate=" + endDate
				+ ", availability=" + availability + ", price=" + price + "]";
	}

}
