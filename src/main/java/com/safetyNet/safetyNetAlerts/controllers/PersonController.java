package com.safetyNet.safetyNetAlerts.controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.DTO.ChildAlertDTO;
import com.safetyNet.safetyNetAlerts.DTO.EmailDTO;
import com.safetyNet.safetyNetAlerts.DTO.FireAddressDTO;
import com.safetyNet.safetyNetAlerts.DTO.PersonInfoDTO;
import com.safetyNet.safetyNetAlerts.Views.ChildAlertView;
import com.safetyNet.safetyNetAlerts.Views.EmailView;
import com.safetyNet.safetyNetAlerts.Views.FireAddressView;
import com.safetyNet.safetyNetAlerts.Views.PersonInfoView;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;
import com.safetyNet.safetyNetAlerts.services.ChildAlertService;
import com.safetyNet.safetyNetAlerts.services.EmailService;
import com.safetyNet.safetyNetAlerts.services.FireAddressService;
import com.safetyNet.safetyNetAlerts.services.PersonInfoService;
import com.safetyNet.safetyNetAlerts.services.PersonService;

@RestController
@Endpoint(id = "person")
public class PersonController {

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	PersonService personService;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	ChildAlertService childAlertService;

	@Autowired
	FireAddressService fireAddressService;

	@Autowired
	PersonInfoService personInfoService;

	@Autowired
	EmailService emailService;

	@GetMapping("/person")
	public ResponseEntity<List<Person>> getAllPerson() {
		logger.info("call url /person");
		List<Person> personLs = personService.getAllPerson();
		return new ResponseEntity<>(personLs, HttpStatus.OK);
	}

	// Endpoint delete a person selected by the firstname and lastname
	@DeleteMapping("person/{firstname} {lastname}")
	private ResponseEntity<HttpStatus> deletePerson(@PathVariable("firstname") String firstName,
			@PathVariable("lastname") String lastName) {
		logger.info("call url /person/{firstname} {lastname}");
		personService.delete(firstName, lastName);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}

	// Endpoint : add a new person
	@PostMapping(value = "/person")
	private ResponseEntity<Person> savePerson(@RequestBody Person person) {
		logger.info("call url /person");
		personService.savePerson(person);
		return new ResponseEntity<Person>(person, HttpStatus.CREATED);
	}

	// Endpoint : modify person (except for firstName and lastName...methods from
	// "https://www.baeldung.com/rest-http-put-vs-post"
	@PutMapping(value = "/person/update/{id}")
	private ResponseEntity<Person> modifyPerson(@RequestBody Person person, @PathVariable int id) {
		logger.info("call url /person/uptade/{id}");
		Optional<Person> firestationOptional = personRepository.findById(id);
		if (!firestationOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		personService.modifyPerson(person, id);

		return ResponseEntity.noContent().build();
	}

	// ChildAltertService
	@JsonView(ChildAlertView.View.class)
	@GetMapping(value = "/childAlert")
	private ChildAlertDTO childAltert(@RequestParam (value ="address") String address) {
		logger.info("call url /childAlert?address={address}");
		return childAlertService.childAlterService(address);
	}

	// FireAddressService
	@JsonView(FireAddressView.fireAddressView.class)
	@GetMapping(value = "/fire")
	private List<FireAddressDTO> fireAddress(@RequestParam (value = "address") String address) {
		logger.info("call url /fire?address=/{address}");
		return fireAddressService.fireAddressServiceByAddress(address);
	}

	// PersoInfoService
	@JsonView(PersonInfoView.personInfoView.class)
	@GetMapping(value = "/personInfo")
	private List<PersonInfoDTO> personInfo(
			@RequestParam ( value = "firstName") String firstname,
			@RequestParam ( value = "lastName") String lastname) {
		logger.info("call url /personInfo?firstName={firstname}&lastName={lastname}");
		return personInfoService.getPersonInfo(firstname, lastname);
	}

	@JsonView(EmailView.View.class)
	@GetMapping(value = "/communityEmail")
	private List<EmailDTO> communityEmail(@RequestParam(value = "city") String city) {
		logger.info("call url /communityEmail?city={city}");
		return emailService.getCommunityEmail(city);
	}
}
