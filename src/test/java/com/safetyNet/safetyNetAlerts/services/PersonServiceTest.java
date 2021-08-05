package com.safetyNet.safetyNetAlerts.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

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
		List<Person> personList = personService.getAllPerson();
		assertEquals(personList.size(), personRepository.count());
	}

	@Test
	void testSavePerson() {
		Person person = new Person("test", "test", "test", "test", "test", "test", "test");
		personService.savePerson(person);
		Person checkSavedPerson = personRepository.findByFirstName("test");
		assertEquals(person.getId(), checkSavedPerson.getId());
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
