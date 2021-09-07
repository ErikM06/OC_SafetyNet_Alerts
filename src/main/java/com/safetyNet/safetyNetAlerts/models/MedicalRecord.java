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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.annotations.MapKeyType;


@Entity
@Table (name ="MedicalRecord")
@SecondaryTable (name = "medications_table", pkJoinColumns = @PrimaryKeyJoinColumn (  name  ="MedicalRecord_id"))
@SecondaryTable (name = "allergies_table", pkJoinColumns = @PrimaryKeyJoinColumn (name = "MedicalRecord_id"))
public class MedicalRecord {

	@Id
	@GeneratedValue

	private int id;
	private String firstName;
	private String lastName;
	private Date birthdate;
	
	
	@Column(name = "medications", table ="medications_table")
	@ElementCollection(targetClass = String.class)
	private List<String> medications;
	@Column(name = "allergies", table ="allergies_table")
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

	public void setBirthdate(String birthdate) {
		try {
			this.birthdate = new SimpleDateFormat("MM/dd/yyyy").parse(birthdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	@Column(name = "medications", table ="medications_table")
	@ElementCollection(targetClass = String.class)
	public List<String> getMedications() {
		return medications;
	}

	public void setMedications(List<String> medications) {
		this.medications = medications;
	}

	@Column(name = "allergies", table ="allergies_table")
	@ElementCollection(targetClass = String.class)
	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

}
