package com.safetyNet.safetyNetAlerts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.services.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/person")

	public List<Person> getAllPerson() {
		return personService.getAllPerson();
	}
	
	/*@GetMapping("person/{lastName}")
	private Person getPersonByLastName (@PathVariable("lastname")String lastname) {
		return personService.getPersonLastName(lastname);
	}*/
	
	@DeleteMapping("person/{id}")
	private void deletePerson(@PathVariable("id") int id) {	
		personService.delete(id);
	}

	@PostMapping(value = "/person")
	private int savePerson (@RequestBody Person person) {
		personService.savePerson(person);
		return person.getId();

	}

}