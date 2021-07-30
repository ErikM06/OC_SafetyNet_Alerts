package com.safetyNet.safetyNetAlerts;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetyNet.safetyNetAlerts.controllers.FirestationDao;
import com.safetyNet.safetyNetAlerts.controllers.MedicalRecordDao;
import com.safetyNet.safetyNetAlerts.controllers.PersonDao;

@Component

public class DaoInit {
	
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:mem:testdb";
	
	
	@Autowired
	PersonDao personDao;
	@Autowired
	FirestationDao firestationDao;
	@Autowired
	MedicalRecordDao medicalRecordDao;
	
	
	
	@PostConstruct
	public void initTables () {
		//init person table
		personDao.personToTable();
		
		//init medicalRecord table
		medicalRecordDao.medicalRecordToTable();
		
		//init fireStation table
		firestationDao.fireStationTable();
	}

}
