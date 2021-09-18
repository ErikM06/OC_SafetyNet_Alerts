package com.safetyNet.safetyNetAlerts.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.DTO.EmailDTO;
import com.safetyNet.safetyNetAlerts.DTO.FireAddressDTO;
import com.safetyNet.safetyNetAlerts.DTO.PersonInfoDTO;
import com.safetyNet.safetyNetAlerts.Views.EmailView;
import com.safetyNet.safetyNetAlerts.Views.FireAddressView;
import com.safetyNet.safetyNetAlerts.Views.PersonInfoView;
import com.safetyNet.safetyNetAlerts.Views.ChildAlertView;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.services.ChildAlertService;
import com.safetyNet.safetyNetAlerts.services.EmailService;
import com.safetyNet.safetyNetAlerts.services.FireAddressService;
import com.safetyNet.safetyNetAlerts.services.PersonInfoService;
import com.safetyNet.safetyNetAlerts.services.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	ChildAlertService childAlertService;
	
	@Autowired
	FireAddressService fireAddressService;
	
	@Autowired
	PersonInfoService personInfoService;
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/person")

	public List<Person> getAllPerson() {
		return personService.getAllPerson();
	}

	
	// Endpoint delete a person selected by the firstname and lastname
	@DeleteMapping("person/{firstname} {lastname}")
	private void deletePerson(@PathVariable("firstname") String firstName, @PathVariable ("lastname") String lastName) {
		personService.delete(firstName, lastName);
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
	
	// ChildAltertService
	@GetMapping(value = "/childAlert/address=/{address}")
	private ChildAlertView childAltert (@PathVariable String address) {
		return childAlertService.childAlterService(address);
	}
	
	// FireAddressService
	@JsonView(FireAddressView.fireAddressView.class)
	@GetMapping(value ="/fire/address=/{address}")
	private List<FireAddressDTO> fireAddress (@PathVariable String address) {
		return fireAddressService.fireAddressServiceByAddress(address);
	}
		
	//PersoInfoService
	
	@JsonView(PersonInfoView.personInfoView.class)
	@GetMapping (value ="personInfo/firstName={firstname}&lastName={lastname}")
	private List<PersonInfoDTO> personInfo (@PathVariable String firstname, @PathVariable String lastname) {
		return personInfoService.getPersonInfo(firstname, lastname);
	}
	
	@JsonView(EmailView.ViewOnlyEmail.class)
	@GetMapping (value ="communityEmail/city={city}")
	private List<EmailDTO> communityEmail (@PathVariable String city) {
		return emailService.getCommunityEmail(city);
	}
	
	
}
