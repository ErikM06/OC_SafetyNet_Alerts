package com.safetyNet.safetyNetAlerts.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.safetyNetAlerts.models.Firestation;
import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;
import com.safetyNet.safetyNetAlerts.repositories.MedicalRecordRepository;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

/*
	 * Station number + covered inhabitant (firstname,lastname, address, phone number)
	 * number of adults and their childs (less 18)
	 * 
	 */
@RestController
public class StationNumberPerHabitantService {

	@Autowired
	FirestationRepository firestationRepository;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	MedicalRecordRepository medicalRecordRepository;

	@GetMapping(value = "/firestation/stationNumber=/{station}")
	public List<String> findClosestStationPerHabitant(@PathVariable int station) {

		List<String> firestationLs = new ArrayList<>();
		List<String> firestationAddress = new ArrayList<>();
		List<String> personLs = null;
		/*List<Date> getBirthdate = null;
		String personLastName = null;
		long millis = System.currentTimeMillis();
		Date date = new Date(millis); */
		Iterable<Firestation> firestationIte = firestationRepository.findAllByStation(station);

		try {
			for (Firestation firestationToLs : firestationIte) {
				String firestationAddress1 = firestationToLs.getAddress();
				 firestationAddress.add(firestationToLs.getAddress());
				personLs = personRepository.getFnLnAddressPhoneByAddress(firestationAddress1);

			}
			for (int i = 0; i <= firestationLs.size(); i++) {
				String address = firestationLs.get(i);
				
				
				/* personLastName = personRepository.getLastNameByAddress(address);
				 *
				 * getBirthdate =
				 * medicalRecordRepository.getBirthDateBylastName(personLastName); if
				 * (getBirthdate.get(i) date) {
				 * 
				 * }
				 */

				String personInfo = personLs.get(i);
				i++;
			}


		} catch (Exception e) {
			
		}
		return personLs;
	}
}
