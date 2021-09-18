package com.safetyNet.safetyNetAlerts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.FloodDTO;
import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;

@Service
public class FloodService {
	
	@Autowired
	FirestationRepository firestationRepository;
	

	public List<FloodDTO> getPersonAndMedicalInfoByListOfStation(List<Integer> station) {
		
		List<FloodDTO> floodDTOLs = firestationRepository.getPersonAndMedicalInfoByListOfStation(station);
		
		return floodDTOLs;
	}

	
}
