package com.safetyNet.safetyNetAlerts.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;
import com.safetyNet.safetyNetAlerts.services.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	@Autowired
	private PersonRepository personRepository;

	@GetMapping("/person")

	public List<Person> getAllPerson() {
		return personService.getAllPerson();
	}

	/*
	 * @GetMapping("person/{lastName}") private Person getPersonByLastName
	 * (@PathVariable("lastname")String lastname) { return
	 * personService.getPersonLastName(lastname); }
	 */
	// Endpoint delete a person selected by the id
	@DeleteMapping("person/{id}")
	private void deletePerson(@PathVariable("id") int id) {
		personService.delete(id);
	}

	// Endpoint : add a new person
	@PostMapping(value = "/person")
	private int savePerson(@RequestBody Person person) {
		personService.savePerson(person);
		return person.getId();
	}
	//Endpoint : modify person (except for firstName and lastName...methods from "https://www.baeldung.com/rest-http-put-vs-post"
	@PutMapping(value = "/person/{id}")
	void modifyPerson(@RequestBody Person person, @PathVariable int id) {
		personService.modifyPerson(person, id);
		personService.savePerson(person);
		
		
	}
}
