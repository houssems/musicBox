package org.issat.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Userprofile implements Serializable{


	private static final long serialVersionUID = -7544283155143451977L;
	@Id
	@GeneratedValue
	private Long id;
	private String name ;
	private String email ;
	private String img;
	private String idSocial ;
	private String Socialtype ;
	
	public Userprofile(){
		
	}
	public Userprofile(String name, String email, String img, String idSocial,
			String socialtype) {
		super();
		this.name = name;
		this.email = email;
		this.img = img;
		this.idSocial = idSocial;
		Socialtype = socialtype;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getIdSocial() {
		return idSocial;
	}

	public void setIdSocial(String idSocial) {
		this.idSocial = idSocial;
	}

	public String getSocialtype() {
		return Socialtype;
	}

	public void setSocialtype(String socialtype) {
		Socialtype = socialtype;
	}
	
	
}
