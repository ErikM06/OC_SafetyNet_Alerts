package com.safetyNet.safetyNetAlerts.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.safetyNet.safetyNetAlerts.models.Firestation;
import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;

@RunWith(SpringRunner.class)
@TestPropertySource("/test.properties")
@SpringBootTest

class FirestationServiceTest {

	@Autowired
	FirestationRepository firestationRepository;

	@Autowired
	FirestationService firestationService;

	@BeforeEach
	private void deleteDataForEachTest() {
		firestationRepository.deleteAll();
	}

	@Test
	void testGetAllFirestation() {
		List<Firestation> firestations = firestationService.getAllFirestation();
		assertEquals(firestations.size(), firestationRepository.count());
	}

	@Test
	void testSaveFirestation() {
		Firestation firestation = new Firestation("test", 1);
		firestationService.saveFirestation(firestation);
		Firestation checkSavedFirestation = firestationRepository.findByAddress("test");
		assertEquals(firestation.getId(), checkSavedFirestation.getId());
	}

	@Test
	void testDeleteFirestation() {
		Firestation firestation = new Firestation("test", 2);
		firestationService.saveFirestation(firestation);
		firestationService.deleteFirestation(firestation.getId());
		assertFalse(firestationRepository.existsById(firestation.getId()));
	}

	@Test
	void testModifyFirestation() {
		Firestation firestation = new Firestation("test", 3);
		firestationService.saveFirestation(firestation);
		Firestation modifiedfirestation = new Firestation("test", 1);
		firestationService.modifyFirestation(modifiedfirestation, firestation.getId());
		Optional<Firestation> checkModif = firestationRepository.findById(firestation.getId());
		assertFalse(firestation.toString().equals(checkModif.toString()));
	}
}
