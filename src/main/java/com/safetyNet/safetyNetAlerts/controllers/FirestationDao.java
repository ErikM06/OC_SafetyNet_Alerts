package com.safetyNet.safetyNetAlerts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetyNet.safetyNetAlerts.models.Root;
import com.safetyNet.safetyNetAlerts.repositories.FiresationRepository;
import com.safetyNet.safetyNetAlerts.services.SafetyNetAlertsFileReader;

@Repository
public class FirestationDao {
	
	SafetyNetAlertsFileReader safetyNetAlertsFileReader;
	Root root;
	
	@Autowired
	FiresationRepository firesationRepository;
	
	public void fireStationTable () {
		
		safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
		Root fireStationObject = safetyNetAlertsFileReader.jsonDataFromUrl();
		
		firesationRepository.saveAll(fireStationObject.firestations);
	
	}

}