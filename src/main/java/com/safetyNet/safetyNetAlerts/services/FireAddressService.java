package com.safetyNet.safetyNetAlerts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.Views.FireAddressView;
import com.safetyNet.safetyNetAlerts.repositories.MedicalRecordRepository;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@SuppressWarnings("unused")
@Service
public class FireAddressService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	MedicalRecordRepository medicalRecordRepository;

	@Autowired
	FireAddressView fireAddressView;


	 public FireAddressView fireAddressServiceByAddress(String address) {

		 fireAddressView.setMedicalRecordLs(medicalRecordRepository.getMedicalRecordByAddress(address));		
		return fireAddressView;

	} 

} 
