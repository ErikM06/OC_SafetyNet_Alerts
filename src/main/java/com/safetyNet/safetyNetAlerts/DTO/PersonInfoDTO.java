package com.safetyNet.safetyNetAlerts.DTO;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.Views.PersonInfoView;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;

@Component
public class PersonInfoDTO {
	@Id
	private int id;
	@JsonView(PersonInfoView.personInfoView.class)
	private String firstName;
	@JsonView(PersonInfoView.personInfoView.class)
	private String lastName;
	@JsonView(PersonInfoView.personInfoView.class)
	private Date birthdate;
	@JsonView(PersonInfoView.personInfoView.class)
	private String email;
	@JsonView(PersonInfoView.personInfoView.class)
	private String address;
	@JsonView(PersonInfoView.personInfoView.class)
	private MedicalRecord medicalRecord;

	
	

	public PersonInfoDTO() {
		super();
	}

	public PersonInfoDTO(String firstName, String lastName, Date birthdate, String email, String address,
			MedicalRecord medicalRecord) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.email = email;
		this.address = address;
		this.medicalRecord = medicalRecord;
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
