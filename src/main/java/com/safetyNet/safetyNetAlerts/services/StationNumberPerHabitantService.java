package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.safetyNetAlerts.models.Firestation;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;
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

	@GetMapping(value = "/firestation/stationNumber=/{station}")
	public List<String> findClosestStationPerHabitant(@PathVariable int station) {
		String jsonStr = null;
		List<String> personsInfo = new ArrayList<>();

		Iterable<Firestation> firestationIte = firestationRepository.findAllByStation(station);
		Iterable<Person> personIte = personRepository.findAll();

		for (Firestation firestation : firestationIte) {
			for (Person person : personIte) {
				if (firestation.getAddress().equals(person.getAddress())) {

					personsInfo.add(person.getFirstName());
					personsInfo.add(person.getLastName());
					personsInfo.add(person.getAddress());
					personsInfo.add(person.getPhone());

				}
			}
		}
	//	jsonStr = JSONArray.toJSONString(personsInfo);
		return personsInfo;

		

	}

}
