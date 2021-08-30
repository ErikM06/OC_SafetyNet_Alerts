package com.safetyNet.safetyNetAlerts;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetyNet.safetyNetAlerts.controllers.FirestationToDb;
import com.safetyNet.safetyNetAlerts.controllers.MedicalRecordToDb;
import com.safetyNet.safetyNetAlerts.controllers.PersonToDb;
import com.safetyNet.safetyNetAlerts.models.Person;

@Component

public class DaoInit {
	
	@Autowired
	PersonToDb personDao;
	@Autowired
	FirestationToDb firestationDao;
	@Autowired
	MedicalRecordToDb medicalRecordDao;
	
	
	
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
