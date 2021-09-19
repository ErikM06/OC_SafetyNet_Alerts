package com.safetyNet.safetyNetAlerts.DTO;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.Views.FireAddressView;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.models.Person;

@Component
public class FireAddressDTO {

	@Id
	private int id;

	@JsonView(FireAddressView.fireAddressView.class)
	private Person personLs;
	@JsonView(FireAddressView.fireAddressView.class)
	private MedicalRecord medicalRecordLs;

	public FireAddressDTO() {
		super();
	}

	public FireAddressDTO(Person personLs, MedicalRecord medicalRecordLs) {
		super();
		this.personLs = personLs;
		this.medicalRecordLs = medicalRecordLs;

	}

	public Person getPersonLs() {
		return personLs;
	}

	public void setPersonLs(Person personLs) {
		this.personLs = personLs;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecordLs;
	}

	public void setMedicalRecord(MedicalRecord medicalRecordLs) {
		this.medicalRecordLs = medicalRecordLs;
	}

}
