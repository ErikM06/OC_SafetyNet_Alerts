package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.PersonInfoDTO;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@Service
public class PersonInfoService {

	private static final Logger logger = LoggerFactory.getLogger(PersonInfoService.class);

	@Autowired
	PersonRepository personRepository;

	public List<PersonInfoDTO> getPersonInfo(String firstname, String lastname) {
		List<PersonInfoDTO> allPersonInfo = new ArrayList<PersonInfoDTO>();
		try {
			List<PersonInfoDTO> personInfoByFirstnameLastname = personRepository
					.getPersonInfoByFirstnameAndLastname(firstname, lastname);
			List<PersonInfoDTO> personInfoByLastName = personRepository.getPersonByLastName(lastname);
			allPersonInfo = Stream.concat(personInfoByFirstnameLastname.stream(), personInfoByLastName.stream())
					.collect(Collectors.toList());
		} catch (NullPointerException e) {
			logger.error("Unable to set List<PersonInfoDTO> ", e);
		}

		return allPersonInfo;

	}

}
