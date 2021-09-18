package com.safetyNet.safetyNetAlerts.DTO;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.models.View;

@Component
public class PersonInfoDTO {

	@Id

	int id;

	@JsonView(View.Public.class)
	String email;
	@JsonView(View.Public.class)
	String address;
	@JsonView(View.Internal.class)
	MedicalRecord medicalRecord;

	public PersonInfoDTO() {

	}

	public PersonInfoDTO(MedicalRecord medicalRecord, String address, String email) {
		super();

		this.medicalRecord = medicalRecord;
		this.address = address;
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
