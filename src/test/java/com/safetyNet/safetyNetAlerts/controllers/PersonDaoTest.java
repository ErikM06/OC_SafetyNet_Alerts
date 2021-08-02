package com.safetyNet.safetyNetAlerts.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"src/test/ressources/application.properties"})

class PersonDaoTest {

	 @Autowired
	 PersonRepository personRepository;
	 
	@Test
	void testPersonToTable() {
		Long person = personRepository
				.count();	
		assertNotNull(person);
	}

}
