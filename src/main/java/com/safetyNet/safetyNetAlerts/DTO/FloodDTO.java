package com.safetyNet.safetyNetAlerts.DTO;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.Views.FloodView;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.models.Person;

@Component
public class FloodDTO {

	@Id
	private int id;
	@JsonView(FloodView.floodView.class)
	private Person person;
	@JsonView(FloodView.floodView.class)
	private MedicalRecord medicalRecord;
	
	public FloodDTO () {
		
	}
	
	public FloodDTO(Person person, MedicalRecord medicalRecord) {
		super();
		this.person = person;
		this.medicalRecord = medicalRecord;
	}
	
	
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

}
