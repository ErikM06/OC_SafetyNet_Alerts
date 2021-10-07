package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.NullArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.repositories.MedicalRecordRepository;

@Service
public class MedicalRecordService {
	
	private static final Logger logger = LoggerFactory.getLogger(MedicalRecordService.class);

	@Autowired
	private MedicalRecordRepository medicalRecordRepository;


	public List<MedicalRecord> getAllMedicalRecord() {
		List<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
		try {
		medicalRecordRepository.findAll().forEach(medicalRecord -> medicalRecords.add(medicalRecord));
		} catch (NullPointerException|NullArgumentException e) {
			logger.error("Unable to set MedicalRecord", e);
		}

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
