package com.safetyNet.safetyNetAlerts.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.apache.commons.lang.NullArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.ChildAlertDTO;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@Service
public class ChildAlertService {
	
	private static final Logger logger = LoggerFactory.getLogger(ChildAlertService.class);
	
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	ChildAlertDTO childAlertDTO;
	

	public ChildAlertDTO childAlterService(String address) {
		
		try {
		LocalDate currentDate = LocalDate.now().minusYears(18);

		Date ageLimit = Date.from(currentDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		childAlertDTO.setPersonLs(personRepository.getFamilyByAddress(address, ageLimit));
		childAlertDTO.setMedicalRecordLs(personRepository.getChildrenByAddress(address, ageLimit));
		} catch (NullPointerException|NullArgumentException e) {
			logger.error("Unable to set ChildAlertDTO");
		}
			
		return childAlertDTO ;

	}
}
