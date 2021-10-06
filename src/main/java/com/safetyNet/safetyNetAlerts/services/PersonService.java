package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@Service
public class PersonService {


	@Autowired
	private PersonRepository personRepository;

	public List<Person> getAllPerson() {
		List<Person> persons = new ArrayList<Person>();
		personRepository.findAll().forEach(person -> persons.add(person));
		
		return persons;
	}

	public void savePerson(Person person) {
		personRepository.save(person);
	}

	public void delete(String firstName, String lastName) {
	Person person =	personRepository.findByFirstNameAndLastName(firstName, lastName);
	personRepository.delete(person);

	}
	public void modifyPerson(Person newPerson, int id) {
		
		    personRepository.findById(id).map(person -> {
			person.setAddress(newPerson.getAddress());
			person.setCity(newPerson.getCity());
			person.setEmail(newPerson.getEmail());
			person.setPhone(newPerson.getPhone());
			person.setZip(newPerson.getZip());
			return personRepository.save(person);
		});
	}

}
