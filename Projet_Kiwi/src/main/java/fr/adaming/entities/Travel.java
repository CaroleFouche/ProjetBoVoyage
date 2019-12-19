package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;

public class Travel implements Serializable {

	private int id;

	private Formula formule;

	private Date startDate;

	private Date endDate;

	private Status status;

	private double price;

	private byte pic;

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
