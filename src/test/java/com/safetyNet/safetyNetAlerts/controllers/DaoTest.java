package com.safetyNet.safetyNetAlerts.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;
import com.safetyNet.safetyNetAlerts.repositories.MedicalRecordRepository;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@RunWith(SpringRunner.class)
@TestPropertySource("/test.properties")
@SpringBootTest

public class DaoTest {

	@Autowired
	PersonRepository personRepository;
	@Autowired
	FirestationRepository firesationRepository;
	@Autowired
	MedicalRecordRepository medicalRecordRepository;

	@Test
	public void testPersonToTable() {
		Long person = personRepository.count();
		assertNotNull(person);
	}

	@Test
	public void testFireStationToTable() {
		Long fireStation = firesationRepository.count();
		assertNotNull(fireStation);
	}

	@Test
	public void testMedicalRecordToTable() {
		Long medicalRecord = medicalRecordRepository.count();
		assertNotNull(medicalRecord);
	}
}
