package com.safetyNet.safetyNetAlerts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.FireAddress;
import com.safetyNet.safetyNetAlerts.DTO.FireAddressDTO;
import com.safetyNet.safetyNetAlerts.repositories.MedicalRecordRepository;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@Service
public class FireAddressService {

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	
	@Autowired
	FireAddressDTO fireAddressDTO;
	
	@Autowired
	FireAddress fireAddress;
	
	public FireAddressDTO fireAddressServiceByAddress (String address) {
	
		fireAddressDTO.setFnLnPhoneAddressBirthdate(personRepository.getFnLnPhoneStationBirthdateByStation(address));
	/*	fireAddressDTO.setMedications(medicalRecordRepository.getFireMedicationAndAllergie(
				fireAddress.getFirstName(), fireAddress.getLastName())); */
		
		
		return fireAddressDTO;
		
	} 

}
