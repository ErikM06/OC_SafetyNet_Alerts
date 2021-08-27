package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
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
	public List<Person> findClosestStationPerHabitant(@PathVariable int station) {
	
		List<String> firestationLs = new ArrayList<>();
		List<Person> personLs = null;
		List<String> personInfo = new ArrayList<>();
		Iterable<Firestation> firestationIte = firestationRepository.findAllByStation(station);
		
		for (Firestation firestationToLs : firestationIte) {
			
			String firestationAddress =firestationToLs.getAddress();
			firestationLs.add(firestationAddress);
			//personLs = personRepository.getFnLnAddressPhoneByAddress(address);
		}
		
		 /* Iterable<Person> personIte = personRepository.findAll();
		
		}
		for (int i = 0; i < firestationLs.size(); i++) {
			Firestation firestation = firestationLs.get(i);
			for (Person personToLs : personIte) {
				if (firestation.getAddress().equals(personToLs.getAddress())) {
					personLs.add(personToLs);
				}
			}
			String json = new Gson().toJson(personInfo);
			// jsonStr = JSONArray.toJSONString(personsInfo);

		} */
		return personLs;
	}
}
