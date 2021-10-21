package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.FloodDTO;
import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;

@Service
public class FloodService {

	private static final Logger logger = LoggerFactory.getLogger(FloodService.class);

	@Autowired
	FirestationRepository firestationRepository;

	public List<FloodDTO> getPersonAndMedicalInfoByListOfStation(List<Integer> station) {

		List<FloodDTO> floodDTOLs = new ArrayList<>();

		try {
			floodDTOLs = firestationRepository.getPersonAndMedicalInfoByListOfStation(station);
		} catch (NullPointerException e) {
			logger.error("Unable to set floddDTO", e);
		}

		return floodDTOLs;
	}

}
