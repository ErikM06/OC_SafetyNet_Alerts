package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.NullArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.models.Firestation;
import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;

@Service
public class FirestationService {
	
	private static final Logger logger = LoggerFactory.getLogger(FirestationService.class);
	
	@Autowired
	private FirestationRepository firesationRepository;

	public List<Firestation> getAllFirestation() {
		List<Firestation> firestation = new ArrayList<Firestation>();
		try {
		firesationRepository.findAll().forEach(firestations -> firestation.add(firestations));
		} catch (NullPointerException e) {
			logger.error("firestation List is empty");
		}
		return firestation;
	}

	public Firestation saveFirestation(Firestation firestation) {
		try {
		firesationRepository.save(firestation);
		} catch (NullArgumentException e) {
			logger.error("Unable to find firestation", e);
		}
		return firestation;
	}

	public void deleteFirestation(int id) {
		firesationRepository.deleteById(id);

	}
	
	public Optional<Firestation> modifyFirestation (Firestation firestation, int id) {
		Optional<Firestation> modifiedFirestation = Optional.empty();
		try {
		modifiedFirestation = firesationRepository.findById(id).map( carsern -> {
		carsern.setStation(firestation.getStation());
		return firesationRepository.save(firestation);
	});
		} catch (NullPointerException|NullArgumentException e) {
			logger.error("unable to set modifiedFirestation",e);
		}
	return modifiedFirestation;
	
		
		
	}
}
