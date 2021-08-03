package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@Service
public class PersonService {


	@Autowired
	private PersonRepository personRepository;

	public List<Person> getAllPerson() {
		List<Person> persons = new ArrayList<Person>();
		personRepository.findAll().forEach(person -> persons.add(person));
		System.out.println(persons);
		return persons;
	}

	/*
	 * public Person getPersonLastName(String lastname) { return
	 * personRepository.getLastName(lastname); }
	 */

	public void savePerson(Person person) {
		personRepository.save(person);
	}

	public void delete(int id) {
		personRepository.deleteById(id);

	}
}
