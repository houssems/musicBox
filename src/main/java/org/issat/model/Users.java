package org.issat.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="users")
public class Users implements Serializable {

	private static final long serialVersionUID = -3799398487915164365L;

	@Id
	@GeneratedValue
	private Long id;
	 
	private String email;
	 
	private String firstName;
	 
	private String lastName;
	 
	private String country;
	 
	private String language;

	private String name;

	private String displayName;

	private String dob;

	private String gender;

	private String location;

	private String profileImageURL;

	private String providerId;

	private String uniqueId;
	 
	public Users(){
		 
	}

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProfileImageURL() {
		return profileImageURL;
	}

	public void setProfileImageURL(String profileImageURL) {
		this.profileImageURL = profileImageURL;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Users(String email, String firstName, String lastName,
			String country, String language, String name, String displayName,
			String dob, String gender, String location, String profileImageURL,
			String providerId, String uniqueId) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.language = language;
		this.name = name;
		this.displayName = displayName;
		this.dob = dob;
		this.gender = gender;
		this.location = location;
		this.profileImageURL = profileImageURL;
		this.providerId = providerId;
		this.uniqueId = uniqueId;
	}
	 
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		result.append(this.getClass().getName() + " Object {" + NEW_LINE);
		result.append(" email: " + email + NEW_LINE);
		result.append(" firstName: " + firstName + NEW_LINE);
		result.append(" lastName: " + lastName + NEW_LINE);
		result.append(" country: " + country + NEW_LINE);
		result.append(" language: " + language + NEW_LINE);
		result.append(" name: " + name + NEW_LINE);
		result.append(" displayName: " + displayName + NEW_LINE);
		result.append(" dob: " + dob + NEW_LINE);
		result.append(" gender: " + gender + NEW_LINE);
		result.append(" location: " + location + NEW_LINE);
		result.append(" uniqueId: " + uniqueId + NEW_LINE);
		result.append(" profileImageURL: " + profileImageURL + NEW_LINE);
		result.append(" providerId: " + providerId + NEW_LINE);
		result.append("}");

		return result.toString();

	}
}
