package com.safetyNet.safetyNetAlerts.services;

import java.text.SimpleDateFormat;
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

		List<String> personLs = new ArrayList<>();
		List<String> personLastName = new ArrayList<>();

		List<Date> getAllBirthDate = new ArrayList<>();
		List<Date> peopleUnderEighteen = new ArrayList<>();

		long millis = System.currentTimeMillis() / 1000; // current time in seconds
		// Calculate 18 years as milli from a TimesTamp calculator
		long eightyYearsAsMillis = 568024668;

		Date eightyYearsLessThanCurrentTime = new Date(millis - eightyYearsAsMillis);

		Iterable<Firestation> firestationIte = firestationRepository.findAll();

		try {

			for (Firestation firestation : firestationIte) {
				if (firestation.getStation() == station) {
					personLastName.addAll(personRepository.getLastNameByAddress(firestation.getAddress()));
					personLs.addAll(personRepository.getFnLnAddressPhoneByAddress(firestation.getAddress()));
				}
			}
			for (String lastName : personLastName) {
				List<String> getBirthdate = new ArrayList<>();
				getBirthdate.addAll(medicalRecordRepository.getBirthDateWithLastName(lastName));

				// Date in db are Str, this convert to Date
				for (String convertToDate : getBirthdate) {
					Date birthdateToDate = new SimpleDateFormat("dd/MM/yyyy").parse(convertToDate);
					getAllBirthDate.add(birthdateToDate);
				}
			}
			for (Date d : getAllBirthDate) {
				if (d.after(eightyYearsLessThanCurrentTime)) {
					peopleUnderEighteen.add(d);
				}
			}
			int count = peopleUnderEighteen.size();
			String valueOfCount = String.valueOf(count);
			personLs.add(valueOfCount);

		} catch (Exception e) {

		}
		return personLs;
	}
}
