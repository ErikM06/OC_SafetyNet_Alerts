package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.models.Firestation;
import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;

@Service
public class FirestationService {

	@Autowired
	private FirestationRepository firesationRepository;

	public List<Firestation> getAllFirestation() {
		List<Firestation> firestation = new ArrayList<Firestation>();
		firesationRepository.findAll().forEach(firestations -> firestation.add(firestations));

		return firestation;
	}

	public Firestation saveFirestation(Firestation firestation) {
		firesationRepository.save(firestation);
		return firestation;
	}

	public void deleteFirestation(int id) {
		firesationRepository.deleteById(id);

	}
	
	public void modifyFirestation (Firestation firestation, int id) {
	firesationRepository.findById(id).map( carsern -> {
		carsern.setStation(firestation.getStation());
		return firesationRepository.save(firestation);
	});
	
		
		
	}
}
