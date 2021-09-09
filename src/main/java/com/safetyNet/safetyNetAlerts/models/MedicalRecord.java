package com.safetyNet.safetyNetAlerts.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table (name ="MedicalRecord")

public class MedicalRecord {

	@Id
	@GeneratedValue
	
	@Column (name = "id")
	private int id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "fastName")
	private String lastName;
	@Column(name = "birthDate")
	private Date birthdate;
	
	
	@ElementCollection()
	@Column(name = "medicalRecord_medications")
	private Collection<String> medications = new ArrayList<String>();
	
	@ElementCollection()
	@Column (name = "medicalRecord_allergies")
	private Collection<String> allergies = new ArrayList<String>();
	
	public MedicalRecord() {
		super();
	}

	public MedicalRecord(String firstName, String lastName, Date birthdate, Collection<String> medications,
			Collection<String> allergies) {
		
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

	
	public Collection<String> getMedications() {
		return medications;
	}
	
	public void setMedications(Collection<String>medications) {
		this.medications = medications;
	}

	
	public Collection<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(Collection<String> allergies) {
		this.allergies = allergies;
	}

}
