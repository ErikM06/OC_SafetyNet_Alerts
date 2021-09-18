package com.safetyNet.safetyNetAlerts.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.safetyNetAlerts.Views.FirestationView;
import com.safetyNet.safetyNetAlerts.controllers.FirestationController;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;
import com.safetyNet.safetyNetAlerts.repositories.MedicalRecordRepository;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

/*
	 * Station number + covered inhabitant (firstname,lastname, address, phone number)
	 * number of adults and their childs (less 18)
	 * 
	 */
@Service
public class StationNumberPerHabitantService {

	@Autowired
	FirestationRepository firestationRepository;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	MedicalRecordRepository medicalRecordRepository;

	
	public FirestationView findClosestStationPerHabitant(int station) {

		
		LocalDate currentDate = LocalDate.now().minusYears(18);
		
		Date ageLimit = Date.from(currentDate.atStartOfDay()
			      .atZone(ZoneId.systemDefault())
			      .toInstant());
		

		FirestationView firestationDTO = new FirestationView();
		
		List<Date> peopleUnderEighteen = personRepository.getChildrenByStation(station, ageLimit);
		List<Date> peopleOverEighteen = personRepository.getAdultByStation(station, ageLimit);
		List<Person> personLs = firestationRepository.findAllByStation(station);
		
		
		firestationDTO.setPersons(personLs);
		firestationDTO.setNbChildren(peopleUnderEighteen.size());
		firestationDTO.setNbAdults(peopleOverEighteen.size());
		

				
				return firestationDTO;
			
	}
}
