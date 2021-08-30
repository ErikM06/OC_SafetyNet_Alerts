package com.safetyNet.safetyNetAlerts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.models.Root;
import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;
import com.safetyNet.safetyNetAlerts.services.SafetyNetAlertsFileReader;

@Repository 

public class FirestationToDb {
	
	SafetyNetAlertsFileReader safetyNetAlertsFileReader;
	Root root;
	
	@Autowired
	FirestationRepository firesationRepository;
	
	public void fireStationTable () {
		
		long checkIfTableEmpty = firesationRepository.count();
		if (checkIfTableEmpty <= 0) {
		safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
		Root fireStationObject = safetyNetAlertsFileReader.jsonDataFromUrl();
		
		firesationRepository.saveAll(fireStationObject.firestations);
		}
	
	}

}
