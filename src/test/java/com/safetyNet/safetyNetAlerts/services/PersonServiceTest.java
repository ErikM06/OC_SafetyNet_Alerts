package com.safetyNet.safetyNetAlerts.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@RunWith(SpringRunner.class)
@TestPropertySource("/test.properties")
@SpringBootTest

class PersonServiceTest {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonService personService;

	@BeforeEach
	private void createDataForEachTest() {
		Person person = new Person("testFirstName", "testLastName", "testAddress", "testCity", "testZip", "testPhone",
				"testEmail");
		personRepository.save(person);
	}

	@AfterEach
	private void deleteDataForEachTest() {
		personRepository.deleteAll();
	}

	@Test
	void testGetAllPerson() {
		List<Person> personList = personService.getAllPerson();
		assertEquals(personList.size(), personRepository.count());
	}

	@Test
	void testSavePerson() {
		Person newPerson = new Person("test", "test", "test", "test", "test", "test", "test");
		personService.savePerson(newPerson);
		assertTrue(personRepository.existsById(newPerson.getId()));
	}

	@Test
	void testDelete() {
		Person newPerson = new Person("test", "test", "test", "test", "test", "test", "test");
		personService.savePerson(newPerson);
		personService.delete(newPerson.getFirstName(), newPerson.getLastName());
		assertFalse(personRepository.existsById(newPerson.getId()));
	}

	@Test
	void testModifyPerson() {
		Person newPerson = personRepository.findByFirstName("testFirstName");
		Person modifiedPerson = new Person("test", "test", "modifiedTest", "modifiedTest", "modifiedTest",
				"modifiedTest", "modifiedTest");
		personService.modifyPerson(modifiedPerson, newPerson.getId());
		Optional<Person> checkModif = personRepository.findById(newPerson.getId());

		assertFalse(modifiedPerson.toString().equals(checkModif.toString()));

	}

}
