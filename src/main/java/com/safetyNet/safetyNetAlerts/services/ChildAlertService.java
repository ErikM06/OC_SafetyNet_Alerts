package com.safetyNet.safetyNetAlerts.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.ChildAlertDTO;
import com.safetyNet.safetyNetAlerts.Views.ChildAlertView;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@Service
public class ChildAlertService {
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	ChildAlertDTO childAlertDTO;


	public ChildAlertDTO childAlterService(String address) {

		LocalDate currentDate = LocalDate.now().minusYears(18);

		Date ageLimit = Date.from(currentDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		childAlertDTO.setPersonLs(personRepository.getFamilyByAddress(address, ageLimit));
		childAlertDTO.setMedicalRecordLs(personRepository.getChildrenByAddress(address, ageLimit));
			

		return childAlertDTO ;

	}
}
