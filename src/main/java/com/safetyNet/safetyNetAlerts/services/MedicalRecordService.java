package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		} catch (NullPointerException | NullArgumentException e) {
			logger.error("Unable to set MedicalRecord", e);
		}

		return medicalRecords;
	}

	public void saveMedicalRecord(MedicalRecord medicalRecord) {
		try {
			medicalRecordRepository.save(medicalRecord);
		} catch (NullArgumentException e) {
			logger.error("Unable to set MedicalRecord", e);
		}
	}

	public void deleteMedicalRecord(String firstName, String lastName) {
		try {
			MedicalRecord medicalRecord = medicalRecordRepository.findByFirstNameAndLastName(firstName, lastName);
			medicalRecordRepository.delete(medicalRecord);
		} catch (NullArgumentException e) {
			logger.error("Ars are null");
		}
	}

	public Optional<MedicalRecord> modifyMedicalRecord(MedicalRecord medicalRecord, int id) {
		Optional<MedicalRecord> modifiedMedicalRecord = Optional.empty();
		try {
			modifiedMedicalRecord = medicalRecordRepository.findById(id).map(modifiedInfo -> {
				modifiedInfo.setBirthdate(medicalRecord.getBirthdate());
				modifiedInfo.setAllergies(medicalRecord.getAllergies());
				modifiedInfo.setMedications(medicalRecord.getMedications());
				return medicalRecordRepository.save(medicalRecord);
			});
		} catch (NullArgumentException | NullPointerException e) {
			logger.error("Unable to set MedicalRecord");
		}
		return modifiedMedicalRecord;
	}
}
