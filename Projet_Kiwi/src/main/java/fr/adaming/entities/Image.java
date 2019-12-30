package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "images")
public class Image implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Lob
	private byte[] photo;

	@Transient
	private String photoString;

	@ManyToOne
	@JoinColumn(name = "d_id", referencedColumnName = "id_d")
	private Destination destination;

	public Image() {
		super();
	}

	public Image(byte[] photo) {
		super();
		this.photo = photo;
	}

	public Image(int id, byte[] photo) {
		super();
		this.id = id;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getPhotoString() {
		return photoString;
	}

	public void setPhotoString(String photoString) {
		this.photoString = photoString;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

}
