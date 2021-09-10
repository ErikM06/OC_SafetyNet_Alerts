package com.safetyNet.safetyNetAlerts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.safetyNetAlerts.DTO.FirestationDTO;
import com.safetyNet.safetyNetAlerts.DTO.PhoneAddressView;
import com.safetyNet.safetyNetAlerts.models.Firestation;
import com.safetyNet.safetyNetAlerts.services.FirestationNumber;
import com.safetyNet.safetyNetAlerts.services.FirestationService;
import com.safetyNet.safetyNetAlerts.services.StationNumberPerHabitantService;

@RestController
public class FirestationController {
	
	@Autowired 
	FirestationService firestationService;
	
	@Autowired
	StationNumberPerHabitantService stationNumberPerHabitantService;
	
	@Autowired
	FirestationNumber firestationNumber;
	
	@GetMapping (value ="/firestation")
	private List<Firestation> getAllFirestations () {
		return firestationService.getAllFirestation();
	}
	
	@PostMapping (value = "/firestation")
	private int saveFirestation (@RequestBody Firestation firestation) {
		firestationService.saveFirestation(firestation);
		return firestation.getId();
	}
	
	@DeleteMapping (value ="/firestation/{id}")
	private void deleteFirestation (@PathVariable int id) {
		firestationService.deleteFirestation(id);
	}
	
	@PutMapping ("/firestation/{id}")
	private void modifyFirestationNumber (@RequestBody Firestation firestation, @PathVariable int id) {
		firestationService.modifyFirestation(firestation, id);
		firestationService.saveFirestation(firestation);
	}
	
	// return person info and nb of children by station area
	@GetMapping(value = "/firestation/stationNumber=/{station}")
	public FirestationDTO findClosestStationPerHabitant(@PathVariable int station) {
		return stationNumberPerHabitantService.findClosestStationPerHabitant(station);
	}
	
	// return phone and address for a firestation
	@GetMapping(value = "/phoneAlert/firestation=/{station}")
	public PhoneAddressView firestationNumber (@PathVariable int station) {
		return firestationNumber.firestationNumberPhone(station);
		
	}
		
	
}
