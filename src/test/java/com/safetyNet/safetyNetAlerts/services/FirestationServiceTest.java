package com.safetyNet.safetyNetAlerts.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.safetyNetAlerts.models.Firestation;
import com.safetyNet.safetyNetAlerts.repositories.FiresationRepository;

@SpringBootTest
class FirestationServiceTest {
	
	@Autowired
	FiresationRepository firesationRepository;
	
	@Autowired
	FirestationService firestationService;

	@Test
	void testGetAllFirestation() {
		List<Firestation>firestations = firestationService
				.getAllFirestation();
		assertEquals(firestations.size(), firesationRepository.count());
	}

	@Test
	void testSaveFirestation() {
		Firestation firestation = new Firestation("test", "test");
		firestationService.saveFirestation(firestation);
		Firestation checkSavedFirestation = firesationRepository.findByAddress("test");
		assertEquals(firestation.getId(), checkSavedFirestation.getId());
	}

	@Test
	void testDeleteFirestation() {
		Firestation firestation = new Firestation("test", "test");
		firestationService.saveFirestation(firestation);
		firestationService.deleteFirestation(firestation.getId());
		assertFalse(firesationRepository.existsById(firestation.getId()));
	}

}
