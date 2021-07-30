package com.safetyNet.safetyNetAlerts.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonParseException;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.models.Root;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;
import com.safetyNet.safetyNetAlerts.services.SafetyNetAlertsFileReader;

@Component
public class PersonDao {

	SafetyNetAlertsFileReader safetyNetAlertsFileReader;
	Root root;
	@Autowired
	PersonRepository personRepository;
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:mem:testdb";

	@SuppressWarnings("static-access")
	
	// refaire le test propre , utiliser une classe init (initialser) avec @component @Autowired les reposi @PostConstruct (init au demarrage)
	public void personToTable() {
		
	

		safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
		Root personObject = safetyNetAlertsFileReader.jsonDataFromUrl();
		
		personRepository.saveAll(personObject.persons);
		

	}

}


