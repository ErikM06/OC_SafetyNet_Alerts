package com.safetyNet.safetyNetAlerts.services;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
		List<String> medication = Arrays.asList("medicationTest","medicationTest");
		List<String> allergies = Arrays.asList("allergiesTest","allergiTest");
		MedicalRecord medicalRecord = new MedicalRecord("test", "test", "test", medication, allergies);
		medicalRecordService.saveMedicalRecord(medicalRecord);
		MedicalRecord checkByFirstName= medicalRecordRepository.findByFirstName("test");
		assertEquals(medicalRecord.getId(), checkByFirstName.getId());
	}

	@Test
	void testDeleteMedicalRecord() {
		String firstName = "test";
		String lastName = "test";
		List<String> medication = Arrays.asList("medicationTest","medicationTest");
		List<String> allergies = Arrays.asList("allergiesTest","allergiestest");
		MedicalRecord medicalRecord = new MedicalRecord(firstName, lastName, "test", medication, allergies);
		medicalRecordService.saveMedicalRecord(medicalRecord);
		medicalRecordService.deleteMedicalRecord(firstName, lastName);
		assertFalse(medicalRecordRepository.existsById(medicalRecord.getId()));
	}
	@Test
	void testModifyMedicalRecord () {
		List<String> medication = Arrays.asList("medicationTest","medicationTest");
		List<String> allergies = Arrays.asList("allergiesTest","allergiTest");
		MedicalRecord medicalRecord = new MedicalRecord("test", "test", "test", medication, allergies);
		medicalRecordService.saveMedicalRecord(medicalRecord);
		List<String> modifiedMed = Arrays.asList("modifiedMedTest");
		List<String>modifiedAll = Arrays.asList("modifiedAlltest");
		MedicalRecord modifiedMedicalRecord = new MedicalRecord("test","test","modifiedtest", modifiedMed, modifiedAll);
		medicalRecordService.modifyMedicalRecord(modifiedMedicalRecord, medicalRecord.getId());
		Optional<MedicalRecord> checkModif = medicalRecordRepository.findById(medicalRecord.getId());
		assertFalse(medicalRecord.toString().equals(checkModif.toString()));
	}
}
