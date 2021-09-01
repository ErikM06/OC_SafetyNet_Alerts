package com.safetyNet.safetyNetAlerts.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class MedicalRecord {
	
	

	@Id
	@GeneratedValue

	private int id;
	private String firstName;
	private String lastName;
	private Date birthdate;
	
	
	
	@Column(name = "medication")
	@ElementCollection(targetClass = String.class)
	private List<String> medications;
	@Column(name = "allergies")
	@ElementCollection(targetClass = String.class)
	private List<String> allergies;
	
	public MedicalRecord() {
		super();
	}

	public MedicalRecord(String firstName, String lastName, Date birthdate, List<String> medications,
			List<String> allergies) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "fastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "birthDate")
	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Column(name = "medication")
	@ElementCollection(targetClass = String.class)
	public List<String> getMedications() {
		return medications;
	}

	public void setMedications(List<String> medications) {
		this.medications = medications;
	}

	@Column(name = "allergies")
	@ElementCollection(targetClass = String.class)
	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

}
