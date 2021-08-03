package com.safetyNet.safetyNetAlerts.services;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.repositories.MedicalRecordRepository;

@SpringBootTest
class MedicalRecordServiceTest {
	
	@Autowired 
	MedicalRecordRepository medicalRecordRepository;
	
	@Autowired
	MedicalRecordService medicalRecordService;
	
	@Test
	void testGetAllMedicalRecord() {
		List<MedicalRecord> medicalRecord = medicalRecordService
				.getAllMedicalRecord();
		assertEquals(medicalRecord.size(), medicalRecordRepository.count());
	}

	@Test
	void testSaveMedicalRecord() {
		List<String> medication = Arrays.asList("medicationTest");
		List<String> allergies = Arrays.asList("allergiesTest");
		MedicalRecord medicalRecord = new MedicalRecord(62, "test", "test", "test", medication, allergies);
		medicalRecordService.saveMedicalRecord(medicalRecord);
		MedicalRecord checkByFirstName= medicalRecordRepository.findByFirstName("test");
		assertEquals(medicalRecord.getId(), checkByFirstName.getId());
	}

	@Test
	void testDeleteMedicalRecord() {
		List<String> medication = Arrays.asList("medicationTest");
		List<String> allergies = Arrays.asList("allergiesTest");
		MedicalRecord medicalRecord = new MedicalRecord(62, "test", "test", "test", medication, allergies);
		medicalRecordService.saveMedicalRecord(medicalRecord);
		medicalRecordService.deleteMedicalRecord(62);
		assertFalse(medicalRecordRepository.existsById(62));
	}

}
