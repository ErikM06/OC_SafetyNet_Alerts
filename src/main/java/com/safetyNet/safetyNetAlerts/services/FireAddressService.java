package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.FireAddressDTO;
import com.safetyNet.safetyNetAlerts.repositories.MedicalRecordRepository;

@Service
public class FireAddressService {

	private static final Logger logger = LoggerFactory.getLogger(FireAddressService.class);

	@Autowired
	MedicalRecordRepository medicalRecordRepository;

	public List<FireAddressDTO> fireAddressServiceByAddress(String address) {
		List<FireAddressDTO> fireAddressDTOls = new ArrayList<>();
		try {
			fireAddressDTOls = medicalRecordRepository.getMedicalRecordByAddress(address);
		} catch (NullPointerException e) {
			logger.error("Unable to set FIreAddressDTO ", e);
		}
		return fireAddressDTOls;

	}

}
