package com.safetyNet.safetyNetAlerts.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;


class StationNumberPerHabitantServiceTest {
	
	@Autowired
	FirestationRepository firestationRepository;
	
	@Autowired
	StationNumberPerHabitantService stationNumberPerHabitantService ;

	@Test
	void testFindClosestStationPerHabitant() {
	stationNumberPerHabitantService.findClosestStationPerHabitant(1);
	
	}

}
