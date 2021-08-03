package com.safetyNet.safetyNetAlerts.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;


@SpringBootTest
class PersonServiceTest {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonService personService;
	

	@Test
	void testGetAllPerson() {
		List<Person>personList = personService
				.getAllPerson();
		assertTrue(personList.size() == personRepository.count());
	}
	
	
	@Test
	void testSavePerson() {
		Person person = new Person(60,"test" , "test", "test", "test", "test", "test", "test");
				personService.savePerson(person);
		Person checkSavedPerson = personRepository.findByFirstName("test");
		assertTrue(person.getId() == checkSavedPerson.getId());
	}
	
	@Test
	void testDelete() {
		Person person = new Person(60,"test" , "test", "test", "test", "test", "test", "test");
		personService.savePerson(person);
		personService.delete(60);
		assertFalse(personRepository.existsById(60));
	}

}
