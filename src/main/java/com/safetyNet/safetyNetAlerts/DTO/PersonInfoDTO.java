package com.safetyNet.safetyNetAlerts.DTO;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.safetyNet.safetyNetAlerts.models.MedicalRecord;

@Component
public class PersonInfoDTO {
	
	@Id
	
	int id;
	String lastname;
	String address;
	Date birthdate;
	String email;
	
	public PersonInfoDTO () {
		
	}

	public PersonInfoDTO(String lastname, String address, Date birthdate, String email, MedicalRecord medicalRecord) {
		super();
		this.lastname = lastname;
		this.address = address;
		this.birthdate = birthdate;
		this.email = email;
		this.medicalRecord = medicalRecord;
	}
	MedicalRecord medicalRecord;
	
	public String getName() {
		return lastname;
	}
	public void setName(String name) {
		this.lastname = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getAge() {
		return birthdate;
	}
	public void setAge(Date age) {
		this.birthdate = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	}
