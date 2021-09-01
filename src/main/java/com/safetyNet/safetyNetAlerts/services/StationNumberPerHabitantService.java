package com.safetyNet.safetyNetAlerts.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

		
		LocalDate currentDate = LocalDate.now().minusYears(18);
		
		Date ageLimit = java.util.Date.from(currentDate.atStartOfDay()
			      .atZone(ZoneId.systemDefault())
			      .toInstant());
		

		FirestationDTO firestationDTO = new FirestationDTO();
		
		List<Date> peopleUnderEighteen = personRepository.getBirthdateByStation(station, ageLimit);
		List<Person> personLs = firestationRepository.findAllByStation(station);
		
		
		firestationDTO.setPersons(personLs);
		firestationDTO.setNbChildren(peopleUnderEighteen.size());

				
				return firestationDTO;
			
	}
}
