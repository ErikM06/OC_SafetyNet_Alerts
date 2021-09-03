package com.safetyNet.safetyNetAlerts.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.PersonDTO;
import com.safetyNet.safetyNetAlerts.models.Child;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@Service
public class ChildAlertService {
	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonDTO personDTO;

	public PersonDTO childAlterService(String address) {

		LocalDate currentDate = LocalDate.now().minusYears(18);

		Date ageLimit = Date.from(currentDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

		List<Person> getPersonByAddress = personRepository.getPersonByAddress(address);
		List<Child> getChildrenByAddress = personRepository.getChildrenByAddress(address, ageLimit);
		
		

		personDTO.setPersonByAddress(getPersonByAddress);
		personDTO.setChildrenByAddress(getChildrenByAddress);

		return personDTO;

	}
}
