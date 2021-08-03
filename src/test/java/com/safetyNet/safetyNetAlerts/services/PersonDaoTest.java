package com.safetyNet.safetyNetAlerts.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.safetyNet.safetyNetAlerts.models.Root;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;
 
@SpringBootTest
class PersonDaoTest {

	SafetyNetAlertsFileReader safetyNetAlertsFileReader;
	Root root;
	@Autowired
	PersonRepository personRepository;
	

	@SuppressWarnings("static-access")
	@Test
	// refaire le test propre , utiliser une classe init (initialser) avec @component @Autowired les reposi @PostConstruct (init au demarrage)
	void personToTableTest() throws JsonParseException {
		

		safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
		Root jsonObject = safetyNetAlertsFileReader.jsonDataFromUrl();
		
		personRepository.saveAll(jsonObject.persons);
		

	}

}
