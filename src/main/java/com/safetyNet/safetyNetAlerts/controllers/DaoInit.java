package com.safetyNet.safetyNetAlerts.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;
import com.safetyNet.safetyNetAlerts.services.PersonDao;
import com.safetyNet.safetyNetAlerts.services.SafetyNetAlertsFileReader;

@Component

public class DaoInit {
	
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:mem:testdb";
	
	
	@Autowired
	PersonDao personDao;
	
	
	
	@PostConstruct
	public void initTables () {
		//init person table
		personDao.personToTable();
		
		//init medicalRecord table
		
		//init Firestation table
	
	}

}
