package com.safetyNet.safetyNetAlerts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.safetyNet.safetyNetAlerts.DTO.FireAddressDTO;
import com.safetyNet.safetyNetAlerts.repositories.MedicalRecordRepository;

@Service
public class FireAddressService {

	@Autowired
	MedicalRecordRepository medicalRecordRepository;

	public List<FireAddressDTO> fireAddressServiceByAddress(String address) {
		
		
		List<FireAddressDTO> fireAddressDTOls = medicalRecordRepository.getMedicalRecordByAddress(address);
		return fireAddressDTOls;

	}

}
