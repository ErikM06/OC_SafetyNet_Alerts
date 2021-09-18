package com.safetyNet.safetyNetAlerts.DTO;

import java.sql.Date;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;

@Component
public class PersonInfoDTO {

	@Id

	int id;

	@JsonView(PersonInfoView.personInfoView.class)
	String lastName;
	@JsonView(PersonInfoView.personInfoView.class)
	Date birthdate;
	@JsonView(PersonInfoView.personInfoView.class)
	String email;
	@JsonView(PersonInfoView.personInfoView.class)
	String address;
	
	MedicalRecord medicalRecord;

	public PersonInfoDTO(String lastName, Date birthdate, String email, String address, MedicalRecord medicalRecord) {
		super();
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.email = email;
		this.address = address;
		this.medicalRecord = medicalRecord;
	}

	public PersonInfoDTO() {
		super();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	
	
}
