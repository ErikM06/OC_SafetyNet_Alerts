package com.safetyNet.safetyNetAlerts.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.safetyNetAlerts.DTO.FirestationDTO;
import com.safetyNet.safetyNetAlerts.models.Firestation;
import com.safetyNet.safetyNetAlerts.models.Person;
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
	public FirestationDTO findClosestStationPerHabitant(@PathVariable int station) {
		
		FirestationDTO firestationDTO = new FirestationDTO();
		List<Person> personLs = firestationRepository.findAllByStation(station);
		firestationDTO.setPersons(personLs);
		
		try {
			for (Person person : personLs) {

				List<String> personBirthdate = personRepository.getBirthdateByFnLn(person);
				
				for (String s : personBirthdate) {

				Date birthdateToDate = new SimpleDateFormat("dd/MM/yyyy").parse(s);
					
					LocalDateTime ldt = LocalDateTime.ofInstant(birthdateToDate.toInstant(), ZoneId.systemDefault());
					
					Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
					
					LocalDate date = LocalDate.now().minusYears(18);
					
					if (birthdateToDate.after(out)) {
					
						List<Date> peopleLessThan18 = new ArrayList<Date>();
					
						peopleLessThan18.add(birthdateToDate);
					
						int numberOfChildren = peopleLessThan18.size();
						firestationDTO.setNbChildren(numberOfChildren);
						}

				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Date> getAllBirthDate = new ArrayList<>();
		List<Date> peopleUnderEighteen = new ArrayList<>();

		return firestationDTO;
	}
}
