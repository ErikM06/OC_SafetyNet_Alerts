package com.safetyNet.safetyNetAlerts.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.models.View;

@Component
public class FireAddressView {
	
	@JsonView(View.Public.class)
	List<FireAddressDTO> medicalRecordLs;
	
	
	
	
	public List<FireAddressDTO> getMedicalRecordLs() {
		return medicalRecordLs;
	}

	public void setMedicalRecordLs(List<FireAddressDTO> medicalRecordLs) {
		this.medicalRecordLs = medicalRecordLs;
	}

}
