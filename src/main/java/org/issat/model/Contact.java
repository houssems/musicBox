package org.issat.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	   @Id
	   @GeneratedValue
	   private Long id;
	   
	   private String email;
	   
	   private String name;

	   private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", email=" + email + ", name=" + name
				+ ", message=" + message + "]";
	}

	public Contact(String email, String name, String message) {
		super();
		this.email = email;
		this.name = name;
		this.message = message;
	}
	public Contact(){
		
	}
}
