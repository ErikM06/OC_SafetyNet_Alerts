package com.safetyNet.safetyNetAlerts.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Medicalrecord {
	
	@Id
	@GeneratedValue
	
	private int id;
	private String firstName;
    private String lastName;
    private String birthdate;
   // private List<String> medications;
    //private List<String> allergies;
	
    @Column (name ="Id", nullable = false, length = 512)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column (name ="First Name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column (name ="Last Name")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column (name ="BirthDate")
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	/*
	//@Column (name = "Medication", nullable = false, length = 512)
	public List<String> getMedications() {
		return medications;
	}
	public void setMedications(List<String> medications) {
		this.medications = medications;
	}
	
	// @Column (name = "Allergies", nullable = false, length = 512)
	public List<String> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}*/
	
}
