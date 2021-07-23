package com.safetyNet.safetyNetAlerts.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.type.StringNVarcharType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

@Entity
public class Medicalrecord {
	
	public Medicalrecord() {
		super();
	}

	public Medicalrecord(int id, String firstName, String lastName, String birthdate, List<String> medications,
			List<String> allergies) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	private String firstName;
	private String lastName;
	private String birthdate;
	
	@Column(name = "medication")
	@ElementCollection(targetClass = String.class)
	private List<String> medications;
	@Column(name = "allergies")
	@ElementCollection(targetClass = String.class)
	private List<String> allergies;

	@Column(name = "Id", nullable = false, length = 512)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "First Name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "Last Name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "BirthDate")
	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
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
