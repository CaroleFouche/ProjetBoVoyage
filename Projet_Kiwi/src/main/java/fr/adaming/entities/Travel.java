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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="travels")
public class Travel implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_t")
	private int id;

	private Formula formule;

	private Date startDate;

	private Date endDate;

	private Status status;

	private double price;

	private byte pic;
	
	//Transformation de l'association UML en Java
	@OneToOne
	@JoinColumn(name="b_id", referencedColumnName= "id_b")
	private Booking booking;
	@OneToOne
	@JoinColumn(name="d_id", referencedColumnName= "id_d")
	private Destination destination;
	@OneToOne
	@JoinColumn(name="c_id", referencedColumnName= "id_c")
	private Car car;
	@OneToMany(mappedBy="travel")
	private List<Hosting> hostings;
	

	public Travel(int id, Formula formule, Date startDate, Date endDate, Status status, double price, byte pic) {
		super();
		this.id = id;
		this.formule = formule;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.price = price;
		this.pic = pic;
	}

	public Travel(Formula formule, Date startDate, Date endDate, Status status, double price, byte pic) {
		super();
		this.formule = formule;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.price = price;
		this.pic = pic;
	}

	public Travel() {
		super();
	}

	
	
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
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

	public Formula getFormule() {
		return formule;
	}

	public void setFormule(Formula formule) {
		this.formule = formule;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte getPic() {
		return pic;
	}

	public void setPic(byte pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "Travel [id=" + id + ", formule=" + formule + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", status=" + status + ", price=" + price + ", pic=" + pic + "]";
	}

}
