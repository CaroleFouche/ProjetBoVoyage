package fr.adaming.entities;

public class Contact {

	private String name;
	private String email;
	private String subject;
	private String text;
	
	public Contact() {
		super();
	}

	public Contact(String name, String email, String subject, String text) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
}
