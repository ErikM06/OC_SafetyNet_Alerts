package com.safetyNet.safetyNetAlerts.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name ="MedicalRecord")

public class MedicalRecord {

	@Id
	@GeneratedValue

	private int id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "fastName")
	private String lastName;
	@Column(name = "birthDate")
	private Date birthdate;
	
	
	@Column(name = "medications")
	@ElementCollection(targetClass = String.class)
	private List<String> medications;
	@Column(name="allergies")
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

		public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		try {
			this.birthdate = new SimpleDateFormat("MM/dd/yyyy").parse(birthdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	@Column(name = "medications")
	public List<String> getMedications() {
		return medications;
	}

	public void setMedications(List<String> medications) {
		this.medications = medications;
	}

	
	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

}
