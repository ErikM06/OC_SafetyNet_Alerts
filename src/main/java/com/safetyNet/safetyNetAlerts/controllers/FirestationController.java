package com.safetyNet.safetyNetAlerts.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.maven.doxia.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.DTO.FirestationNumberDTO;
import com.safetyNet.safetyNetAlerts.DTO.FloodDTO;
import com.safetyNet.safetyNetAlerts.DTO.PhoneAddressDTO;
import com.safetyNet.safetyNetAlerts.Views.FirestationNumberView;
import com.safetyNet.safetyNetAlerts.Views.FloodView;
import com.safetyNet.safetyNetAlerts.Views.PhoneAddressView;
import com.safetyNet.safetyNetAlerts.models.Firestation;
import com.safetyNet.safetyNetAlerts.repositories.FirestationRepository;
import com.safetyNet.safetyNetAlerts.services.FirestationNumber;
import com.safetyNet.safetyNetAlerts.services.FirestationService;
import com.safetyNet.safetyNetAlerts.services.FloodService;
import com.safetyNet.safetyNetAlerts.services.StationNumberService;

@RestController
public class FirestationController {

	@Autowired
	FirestationService firestationService;

	@Autowired
	StationNumberService stationNumberPerHabitantService;

	@Autowired
	FirestationNumber firestationNumber;

	@Autowired
	FloodService floodService;

	@Autowired
	FirestationRepository firestationRepository;
	
	private static Logger logger = Logger.getLogger(FirestationController.class);
	

	@GetMapping(value = "/firestation")
	private ResponseEntity <List<Firestation>> getAllFirestations() {
		List<Firestation> firestationLs = firestationService.getAllFirestation();
		logger.log(Level.INFO, firestationLs);
		if (firestationLs.isEmpty()) {
			logger.log(Level.ERROR, "Firestation list is empty");
		}
		return new ResponseEntity<>(firestationLs, HttpStatus.OK);
		
	}

	@PostMapping(value = "/firestation")
	private ResponseEntity<Firestation> saveFirestation(@RequestBody Firestation firestation) {
		firestationService.saveFirestation(firestation);
		return new ResponseEntity<Firestation>(firestation, HttpStatus.CREATED);

	}

	@DeleteMapping(value = "/firestation/{id}")
	private ResponseEntity<HttpStatus> deleteFirestation(@PathVariable int id) {
		firestationService.deleteFirestation(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/firestation/update/{id}")
	private ResponseEntity<Firestation> modifyFirestationNumber(@RequestBody Firestation firestation,
			@PathVariable int id) {
		Optional<Firestation> firestationOptional = firestationRepository.findById(id);
		if (!firestationOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		firestationService.modifyFirestation(firestation, id);
		firestationService.saveFirestation(firestation);

		return ResponseEntity.noContent().build();

	}

	// return person info and nb of children by station area
	@JsonView(FirestationNumberView.personInfoView.class)
	@GetMapping(value = "/firestation/stationNumber=/{station}")
	public FirestationNumberDTO findClosestStationPerHabitant(@PathVariable int station) {
		return stationNumberPerHabitantService.findClosestStationPerHabitant(station);
	}

	// return phone and address for a firestation
	@JsonView(PhoneAddressView.PhoneAddressViewForPerson.class)
	@GetMapping(value = "/phoneAlert/firestation=/{station}")
	public List<PhoneAddressDTO> firestationNumber(@PathVariable int station) {
		return firestationNumber.firestationNumberPhone(station);
	}

	@JsonView(FloodView.floodView.class)
	@GetMapping(value = "/flood/stations/stations=/{station}")
	public List<FloodDTO> personAndMedicalInfoByListOfStation(@PathVariable List<Integer> station) {
		return floodService.getPersonAndMedicalInfoByListOfStation(station);

	}

}
