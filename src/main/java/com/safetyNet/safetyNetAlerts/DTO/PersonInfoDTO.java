package com.safetyNet.safetyNetAlerts.DTO;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.Views.PersonInfoView;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.models.Person;

@Component
public class PersonInfoDTO {
	@Id
	private int id;
	@JsonView(PersonInfoView.personInfoView.class)
	private Person personLs;
	@JsonView(PersonInfoView.personInfoView.class)
	private MedicalRecord medicalRecordLs;
	
	public PersonInfoDTO() {
		super();
	}
	public PersonInfoDTO(Person personLs, MedicalRecord medicalRecordLs) {
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
	public MedicalRecord getMedicalRecordLs() {
		return medicalRecordLs;
	}
	public void setMedicalRecordLs(MedicalRecord medicalRecordLs) {
		this.medicalRecordLs = medicalRecordLs;
	}
	
}
