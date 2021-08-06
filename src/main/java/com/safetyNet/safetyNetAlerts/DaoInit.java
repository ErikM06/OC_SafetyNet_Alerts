package com.safetyNet.safetyNetAlerts;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetyNet.safetyNetAlerts.controllers.FirestationDao;
import com.safetyNet.safetyNetAlerts.controllers.MedicalRecordDao;
import com.safetyNet.safetyNetAlerts.controllers.PersonDao;
import com.safetyNet.safetyNetAlerts.models.Person;

@Component

public class DaoInit {
	
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
