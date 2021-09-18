package com.safetyNet.safetyNetAlerts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.FloodView;
import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;

@Service
public class FloodService {
	@Autowired
	FirestationRepository firestationRepository;
	
	@Autowired
	FloodView floodView;

	public FloodView getPersonAndMedicalInfoByListOfStation(List<Integer> station) {
		
		floodView.setPersonAndMedicalInfoByListOfStation(firestationRepository.getPersonAndMedicalInfoByListOfStation(station));
		
		return floodView;
	}

	
}
