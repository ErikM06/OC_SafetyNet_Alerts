package com.safetyNet.safetyNetAlerts.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MedicalRecord")
@Data
@NoArgsConstructor
public class MedicalRecord {

	@Id
	@GeneratedValue 
	
	
	@Column(name = "id")
	private int id;
	@JsonView(View.Internal.class)
	@Column(name = "firstName")
	private String firstName;
	@JsonView(View.Internal.class)
	@Column(name = "lastName")
	private String lastName;
	@JsonView(View.Internal.class)
	@Column(name = "birthDate")
	private Date birthdate;
	@JsonView(View.Public.class)
	@ElementCollection()
	private List<String> medications = new ArrayList<String>();
	@JsonView(View.Public.class)
	@ElementCollection()
	private List<String> allergies = new ArrayList<String>();

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
