package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<FloodDTO> getPersonAndMedicalInfoByListOfStation(List<String> stationList) {

		List<FloodDTO> floodDTOLs = new ArrayList<>();
		List<Integer> stationListToInt = new ArrayList<>();
		try {
			stationListToInt = stationList.stream().map(Integer::parseInt).collect(Collectors.toList());
			for (int i = 0; i < stationListToInt.size(); i++) {
				floodDTOLs
						.addAll(firestationRepository.getPersonAndMedicalInfoByListOfStation(stationListToInt.get(i)));
			}
		} catch (NullPointerException e) {
			logger.error("Unable to set floddDTO", e);
		}

		return floodDTOLs;
	}

}
