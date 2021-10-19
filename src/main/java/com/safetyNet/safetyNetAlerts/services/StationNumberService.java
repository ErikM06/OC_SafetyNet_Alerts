package com.safetyNet.safetyNetAlerts.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.NullArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.safetyNet.safetyNetAlerts.DTO.FirestationNumberDTO;
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
public class StationNumberService {

	private static final Logger logger = LoggerFactory.getLogger(StationNumberService.class);

	@Autowired
	FirestationRepository firestationRepository;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	MedicalRecordRepository medicalRecordRepository;

	public FirestationNumberDTO findClosestStationPerHabitant(int station) {

		FirestationNumberDTO firestationDTO = new FirestationNumberDTO();

		try {
			LocalDate currentDate = LocalDate.now().minusYears(18);

			Date ageLimit = Date.from(currentDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

			List<Date> peopleUnderEighteen = personRepository.getChildrenByStation(station, ageLimit);
			List<Date> peopleOverEighteen = personRepository.getAdultByStation(station, ageLimit);
			List<Person> personLs = firestationRepository.findAllByStation(station);

			firestationDTO.setPersons(personLs);
			firestationDTO.setNbChildren(peopleUnderEighteen.size());
			firestationDTO.setNbAdults(peopleOverEighteen.size());
		} catch (NullPointerException | NullArgumentException e) {
			logger.error("Unable to set firestationDTO ", e);
		}
		return firestationDTO;
	}
}
