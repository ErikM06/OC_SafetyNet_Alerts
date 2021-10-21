package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@Service
public class PersonService {

	private static final Logger logger = Logger.getLogger(PersonService.class);

	@Autowired
	private PersonRepository personRepository;

	public List<Person> getAllPerson() {
		List<Person> persons = new ArrayList<Person>();
		try {
			personRepository.findAll().forEach(person -> persons.add(person));
		} catch (NullPointerException e) {
			logger.error("Unable to set List<Person> ", e);
		}
		return persons;
	}

	public void savePerson(Person person) {
		try {
			personRepository.save(person);
		} catch (NullPointerException e) {
			logger.error("Arg is null ", e);
		}
	}

	public void delete(String firstName, String lastName) {
		try {
			Person person = personRepository.findByFirstNameAndLastName(firstName, lastName);
			personRepository.delete(person);
		} catch (NullPointerException e) {
			logger.error("Args are null ", e);
		}

	}

	public Optional<Person> modifyPerson(Person newPerson, int id) {
		Optional<Person> modifiedPerson = Optional.empty();
		try {
			modifiedPerson = personRepository.findById(id).map(person -> {
				person.setAddress(newPerson.getAddress());
				person.setCity(newPerson.getCity());
				person.setEmail(newPerson.getEmail());
				person.setPhone(newPerson.getPhone());
				person.setZip(newPerson.getZip());
				return personRepository.save(person);
			});
		} catch (NullPointerException e) {
			logger.error("Unable to set Optional<Person> modifiedPerson ", e);
		}
		return modifiedPerson;
	}

}
