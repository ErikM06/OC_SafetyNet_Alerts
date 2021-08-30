package com.safetyNet.safetyNetAlerts.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;


class StationNumberPerHabitantServiceTest {
	
	@Autowired
	FirestationRepository firestationRepository;
	
	@Autowired
	StationNumberPerHabitantService stationNumberPerHabitantService ;
	
	@Autowired
	PersonRepository personRepository;

	@Test
	void testFindClosestStationPerHabitant() {
	Iterable<Person> person = personRepository.findAll();
	for(Person persons : person) {
		persons.getAddress();
		
	}
	
	//List<String> stationResult = stationNumberPerHabitantService.findClosestStationPerHabitant(1);
	//assertNotNull(stationResult);
	
	}

}
