package com.safetyNet.safetyNetAlerts.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.PersonInfoDTO;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@Service
public class PersonInfoService {

	@Autowired
	PersonRepository personRepository;

	public List<PersonInfoDTO> getPersonInfo(String firstname, String lastname) {

		List<PersonInfoDTO> personInfoByFirstnameLastname = personRepository
				.getPersonInfoByFirstnameAndLastname(firstname, lastname);
		List<PersonInfoDTO> personInfoByLastName = personRepository.getPersonByLastName(lastname);
		List<PersonInfoDTO> allPersonInfo = Stream
				.concat(personInfoByFirstnameLastname.stream(), personInfoByLastName.stream())
				.collect(Collectors.toList());

		return allPersonInfo;

	}

}
