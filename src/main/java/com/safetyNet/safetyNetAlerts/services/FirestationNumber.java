package com.safetyNet.safetyNetAlerts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.PhoneAddress;
import com.safetyNet.safetyNetAlerts.DTO.PhoneAddressDTO;
import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;

@Service
public class FirestationNumber {
	
	@Autowired
	FirestationRepository firestationRepository;
	
	@Autowired
	PhoneAddressDTO phoneAddressDTO;
	
	
	public PhoneAddressDTO firestationNumberPhone(int station) {
		
		List<PhoneAddress> phoneAddressByStation = firestationRepository.findPhoneByStation(station);
		
		phoneAddressDTO.setPhoneAddress(phoneAddressByStation);
		
		return phoneAddressDTO;
		
		
	}

}
