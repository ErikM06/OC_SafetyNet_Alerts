package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.NullArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.PhoneAddressDTO;
import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;

@Service
public class FirestationNumber {

	private static final Logger logger = LoggerFactory.getLogger(FirestationNumber.class);

	@Autowired
	FirestationRepository firestationRepository;

	public List<PhoneAddressDTO> firestationNumberPhone(int station) {

		List<PhoneAddressDTO> phoneAddressByStation = new ArrayList<>();

		try {
			phoneAddressByStation = firestationRepository.findPhoneByStation(station);
		} catch (NullPointerException | NullArgumentException e) {
			logger.error("Unable to set PhoneAddressDTO ", e);
		}

		return phoneAddressByStation;

	}

}
