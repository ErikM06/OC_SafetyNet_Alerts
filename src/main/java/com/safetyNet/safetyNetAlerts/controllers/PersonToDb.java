package com.safetyNet.safetyNetAlerts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.models.Root;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;
import com.safetyNet.safetyNetAlerts.services.SafetyNetAlertsFileReader;

@Component
public class PersonToDb {

	SafetyNetAlertsFileReader safetyNetAlertsFileReader;
	Root root;
	@Autowired
	PersonRepository personRepository;
	

	@SuppressWarnings("static-access")
	
	// refaire le test propre , utiliser une classe init (initialser) avec @component @Autowired les reposi @PostConstruct (init au demarrage)
	public void personToTable() {
		
	
		long checkIfTableEmpty = personRepository.count();
		if (checkIfTableEmpty <=0) {
		safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
		Root personObject = safetyNetAlertsFileReader.jsonDataFromUrl();
		
		personRepository.saveAll(personObject.persons);
		}

	}

}

