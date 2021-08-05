package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.repositories.MedicalRecordRepository;

@Service
public class MedicalRecordService {

	@Autowired
	private MedicalRecordRepository medicalRecordRepository;


	public List<MedicalRecord> getAllMedicalRecord() {
		List<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
		medicalRecordRepository.findAll().forEach(medicalRecord -> medicalRecords.add(medicalRecord));

		return medicalRecords;
	}

	public void saveMedicalRecord(MedicalRecord medicalRecord) {
		medicalRecordRepository.save(medicalRecord);
	}

	public void deleteMedicalRecord(String firstName , String lastName) {
		MedicalRecord medicalRecord = medicalRecordRepository.findByFirstNameAndLastName(firstName, lastName);
		medicalRecordRepository.delete(medicalRecord);
	}
	public void modifyMedicalRecord(MedicalRecord medicalRecord, int id) {
		
		    medicalRecordRepository.findById(id).map(modifiedInfo -> { 
			modifiedInfo.setBirthdate(medicalRecord.getBirthdate());
			modifiedInfo.setAllergies(medicalRecord.getAllergies());
			modifiedInfo.setMedications(medicalRecord.getMedications());
			return medicalRecordRepository.save(medicalRecord);
			});
		
	}
}
