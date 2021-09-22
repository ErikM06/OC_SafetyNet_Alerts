package com.safetyNet.safetyNetAlerts.services;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.repositories.MedicalRecordRepository;

@RunWith(SpringRunner.class)
@SpringBootTest

class MedicalRecordServiceTest {
	
	@Autowired 
	MedicalRecordRepository medicalRecordRepository;
	
	@Autowired
	MedicalRecordService medicalRecordService;
	
	@BeforeEach
	private void setUpMedicalRecord() {
		List<String> medication = Arrays.asList("medicationTest","medicationTest");
		List<String> allergies = Arrays.asList("allergiesTest","allergiTest");
		MedicalRecord medicalRecord = new MedicalRecord("test", "test", null, medication, allergies);
		medicalRecordService.saveMedicalRecord(medicalRecord);
	}
	
	@AfterEach
	private void deleteDataAfterEachTest() {
		medicalRecordRepository.deleteAll();
	}
	
	@Test
	public void testGetAllMedicalRecord() {
		List<MedicalRecord> medicalRecord = medicalRecordService
				.getAllMedicalRecord();
		assertEquals(medicalRecord.size(), medicalRecordRepository.count());
	}

	@Test
	public void testSaveMedicalRecord() {
	
		MedicalRecord newMedicalRecord = new MedicalRecord("newTest", "newTest", null, null, null);
		medicalRecordService.saveMedicalRecord(newMedicalRecord);
		assertTrue(medicalRecordRepository.existsById(newMedicalRecord.getId()));
	}

	@Test
	 public void testDeleteMedicalRecord() {
	
		MedicalRecord newMedicalRecord = medicalRecordRepository.findByFirstName("test");
		medicalRecordService.deleteMedicalRecord(newMedicalRecord.getFirstName(), newMedicalRecord.getLastName());
		assertFalse(medicalRecordRepository.existsById(newMedicalRecord.getId()));
	}
	@Test
	 public void testModifyMedicalRecord () throws ParseException {
		
		MedicalRecord newMedicalRecord = medicalRecordRepository.findByFirstName("test");
		List<String> modifiedMed = Arrays.asList("modifiedMedTest");
		List<String>modifiedAll = Arrays.asList("modifiedAlltest");
		SimpleDateFormat dateFor = new SimpleDateFormat("yyyy/MM/dd");
		Date modifiedBirthdate = dateFor.parse ("2014/01/01");
		MedicalRecord modifiedMedicalRecord = new MedicalRecord("test","test", modifiedBirthdate, modifiedMed, modifiedAll);
		medicalRecordService.modifyMedicalRecord(modifiedMedicalRecord, newMedicalRecord.getId());
		Optional<MedicalRecord> checkModif = medicalRecordRepository.findById(newMedicalRecord.getId());
		assertFalse(newMedicalRecord.toString().equals(checkModif.toString()));
	}
} 
