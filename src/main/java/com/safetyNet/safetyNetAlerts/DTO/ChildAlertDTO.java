package com.safetyNet.safetyNetAlerts.DTO;

import java.util.List;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.Views.ChildAlertView;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.models.Person;

@Component

public class ChildAlertDTO {

	@Id
	private int id;

	@JsonView(ChildAlertView.View.class)
	private List<MedicalRecord> medicalRecordLs;

	@JsonView(ChildAlertView.ViewForFamily.class)
	private List<Person> personLs;

	public List<Person> getPersonLs() {
		return personLs;
	}

	public void setPersonLs(List<Person> personLs) {
		this.personLs = personLs;
	}

	public List<MedicalRecord> getMedicalRecordLs() {
		return medicalRecordLs;
	}

	public void setMedicalRecordLs(List<MedicalRecord> medicalRecordLs) {
		this.medicalRecordLs = medicalRecordLs;
	}
}
