package com.safetyNet.safetyNetAlerts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.models.Root;
import com.safetyNet.safetyNetAlerts.repositories.MedicalRecordRepository;
import com.safetyNet.safetyNetAlerts.services.SafetyNetAlertsFileReader;

@Repository
public class MedicalRecordToDb {

	SafetyNetAlertsFileReader safetyNetAlertsFileReader;
	Root root;

	@Autowired
	MedicalRecordRepository medicalRecordRepository;

	public void medicalRecordToTable() {
		long checkIfTableEmpty = medicalRecordRepository.count();
		if (checkIfTableEmpty <= 0) {
			safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
			Root medicalRecordObject = safetyNetAlertsFileReader.jsonDataFromUrl();

			medicalRecordRepository.saveAll(medicalRecordObject.medicalrecords);
		}
	}
}
