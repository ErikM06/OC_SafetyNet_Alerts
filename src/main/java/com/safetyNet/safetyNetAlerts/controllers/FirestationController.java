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

import com.safetyNet.safetyNetAlerts.models.Firestation;
import com.safetyNet.safetyNetAlerts.services.FirestationService;

@RestController
public class FirestationController {
	
	@Autowired 
	FirestationService firestationService;
	
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
}
