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

	@Autowired
	private MedicalRecord medicalRecord;

	public List<MedicalRecord> getAllMedicalRecord() {
		List<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
		medicalRecordRepository.findAll().forEach(medicalRecord -> medicalRecords.add(medicalRecord));

		return medicalRecords;
	}

	public void saveMedicalRecord(MedicalRecord medicalrecord) {
		medicalRecordRepository.save(medicalRecord);
	}

	public void deleteMedicalRecord(int id) {
		medicalRecordRepository.deleteById(id);

	}
}
