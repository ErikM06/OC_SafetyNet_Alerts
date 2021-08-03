package com.safetyNet.safetyNetAlerts.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.safetyNet.safetyNetAlerts.repositories.FiresationRepository;
import com.safetyNet.safetyNetAlerts.repositories.MedicalRecordRepository;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"src/test/ressources/application.properties"})

class DaoTest {

	 @Autowired
	 PersonRepository personRepository;
	 @Autowired
	 FiresationRepository firesationRepository;
	 @Autowired
	 MedicalRecordRepository medicalRecordRepository;
	 
	@Test
	public void testPersonToTable() {
		Long person = personRepository
				.count();	
		assertNotNull(person);
	}
	
	@Test
	public void testFireStationToTable () {
		Long fireStation = firesationRepository
				.count();
		assertNotNull(fireStation);
	}
	
	@Test
	public void testMedicalRecordToTable () {
		Long medicalRecord = medicalRecordRepository
				.count();
		assertNotNull(medicalRecord);
	}
}