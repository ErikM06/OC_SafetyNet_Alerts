package com.safetyNet.safetyNetAlerts.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.google.gson.GsonBuilder;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.models.Root;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;
 
@SpringBootTest
class PersonDaoTest {

	SafetyNetAlertsFileReader safetyNetAlertsFileReader;
	Root root;
	@Autowired
	PersonRepository personRepository;
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:mem:testdb";

	@SuppressWarnings("static-access")
	@Test
	// refaire le test propre , utiliser une classe init (initialser) avec @component @Autowired les reposi @PostConstruct (init au demarrage)
	void personToTableTest() throws JsonParseException {
		

		safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
		Root jsonObject = safetyNetAlertsFileReader.jsonDataFromUrl();
		
		personRepository.saveAll(jsonObject.persons);
		

	}

}
