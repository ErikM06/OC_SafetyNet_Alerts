package com.safetyNet.safetyNetAlerts.services;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties") //missing table error 

class PersonServiceTest {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonService personService;
	
	@Test
	void testGetAllPerson() {
		List<Person> personList = personService.getAllPerson();
		assertEquals(personList.size(), personRepository.count());
	}

	@Test
	void testSavePerson() {
		Person person = new Person("test", "test", "test", "test", "test", "test", "test");
		personService.savePerson(person);
		assertTrue(personRepository.existsById(person.getId()));
	}

	@Test
	void testDelete() {
		String firstName = "firstName test";
		String lastName = "lastName test";
		Person person = new Person(firstName, lastName, "test", "test", "test", "test", "test");
		personService.savePerson(person);
		personService.delete(firstName,lastName);
		assertFalse(personRepository.existsById(person.getId()));
	}

	@Test
	void testModifyPerson() { 
		Person lastPerson = new Person("test", "test", "test", "test", "test", "test", "test");
		personService.savePerson(lastPerson);
		
		Person modifiedPerson = new Person ("test","test","modifiedTest","modifiedTest","modifiedTest","modifiedTest", "modifiedTest");
		personService.modifyPerson(modifiedPerson, lastPerson.getId());
		Optional<Person> checkModif = personRepository.findById(lastPerson.getId());
		
		assertFalse(modifiedPerson.toString().equals(checkModif.toString()));
		

	}

}
