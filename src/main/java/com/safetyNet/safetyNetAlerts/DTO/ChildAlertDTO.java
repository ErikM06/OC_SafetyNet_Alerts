package com.safetyNet.safetyNetAlerts.DTO;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.Views.ChildAlertView;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.models.Person;

import lombok.Data;


@Component
@Data
public class ChildAlertDTO {
	
	@Id
	private int id;
	@JsonView (ChildAlertView.ViewForFamily.class)
	private Person personLs;
	@JsonView (ChildAlertView.View.class)
	private MedicalRecord medicalRecordLs;

	public ChildAlertDTO() {
		super();
	}

	public ChildAlertDTO(Person personLs, MedicalRecord medicalRecordLs) {
		super();
		this.personLs = personLs;
		this.medicalRecordLs = medicalRecordLs;
	}
	
	
	
}
