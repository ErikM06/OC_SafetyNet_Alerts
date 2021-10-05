package com.safetyNet.safetyNetAlerts.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.Views.MedicalRecordView;

import lombok.Data;

@Entity
@Table(name = "MedicalRecord")
@Data

public class MedicalRecord {

	@Id
	@GeneratedValue 
	
	
	@Column(name = "id")
	private int id;
	@JsonView(MedicalRecordView.MedicalRecordfirstNameLastName.class)
	@Column(name = "firstName")
	private String firstName;
	@JsonView(MedicalRecordView.MedicalRecordfirstNameLastName.class)
	@Column(name = "lastName")
	private String lastName;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "MM/dd/yyyy")
	@JsonView(MedicalRecordView.Birthdate.class)
	@Column(name = "birthDate")
	private Date birthdate;
	@JsonView(MedicalRecordView.MedicationAndAllergie.class)
	@ElementCollection()
	private List<String> medications = new ArrayList<String>();
	@JsonView(MedicalRecordView.MedicationAndAllergie.class)
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

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
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
