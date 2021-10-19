package com.safetyNet.safetyNetAlerts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetyNet.safetyNetAlerts.models.Root;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;
import com.safetyNet.safetyNetAlerts.services.SafetyNetAlertsFileReader;

@Component
public class PersonToDb {
	@Autowired
	private SafetyNetAlertsFileReader safetyNetAlertsFileReader;

	@Autowired
	private PersonRepository personRepository;

	public void personToTable() {

		long checkIfTableEmpty = personRepository.count();
		if (checkIfTableEmpty <= 0) {
			safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
			Root personObject = safetyNetAlertsFileReader.jsonDataFromUrl();

			personRepository.saveAll(personObject.persons);
		}
	}
}
