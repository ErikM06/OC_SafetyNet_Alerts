package com.safetyNet.safetyNetAlerts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.PersonInfoView;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@Service
public class PersonInfoService {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonInfoView personInfoView;
	
	public PersonInfoView getPersonInfo(String firstname, String lastname) {
		
		personInfoView.setPersonInfoLs(personRepository.getPersonInfoByFirstnameAndLastname(firstname, lastname));
		personInfoView.setPersonWithSameLastName(personRepository.getPersonByLastName(lastname));
		return personInfoView ;
		
	}

}
