package com.safetyNet.safetyNetAlerts.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

	private static final Logger logger = LoggerFactory.getLogger(FirestationController.class);

	@GetMapping(value = "/firestation")
	private ResponseEntity<?> getAllFirestations(@RequestParam( value = "firestationNumber", required = false) Integer station) {
		List<Object> ls = new ArrayList<Object>();
		if (station == null) {
			logger.info("call url /firestation");
			List<Firestation> firestationLs = firestationService.getAllFirestation();
			ls.addAll(firestationLs);
			return new ResponseEntity<>(firestationLs, HttpStatus.OK);
		}if (station != null) {
			findClosestStationPerHabitant(station);
			ls.add(findClosestStationPerHabitant(station));
		}
		 return new ResponseEntity<>(ls,HttpStatus.OK);
	}
	
	@JsonView(FirestationNumberView.personInfoView.class)
	public FirestationNumberDTO findClosestStationPerHabitant(int station) {
		logger.info("call url /firestation?stationNumber={station}");
		return stationNumberPerHabitantService.findClosestStationPerHabitant(station);
	}

	@PostMapping(value = "/firestation")
	private ResponseEntity<Firestation> saveFirestation(@RequestBody Firestation firestation) {
		logger.info("call url /firestation");
		firestationService.saveFirestation(firestation);
		return new ResponseEntity<Firestation>(firestation, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/firestation/{id}")
	private ResponseEntity<HttpStatus> deleteFirestation(@PathVariable int id) {
		logger.info("call url /firestation/{id}");
		firestationService.deleteFirestation(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/firestation/update/{id}")
	private ResponseEntity<Firestation> modifyFirestationNumber(@RequestBody Firestation firestation,
			@PathVariable int id) {
		logger.info("call url /firestation/uptade/{id}");
		Optional<Firestation> firestationOptional = firestationRepository.findById(id);
		if (!firestationOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		firestationService.modifyFirestation(firestation, id);
		firestationService.saveFirestation(firestation);

		return ResponseEntity.noContent().build();
	}

	// return person info and nb of children by station area

	

	// return phone and address for a firestation
	@JsonView(PhoneAddressView.PhoneAddressViewForPerson.class)
	@GetMapping(value = "/phoneAlert?firestation={firestation_number}")
	public List<PhoneAddressDTO> firestationNumber(@RequestParam(value = "firestation_number") int station) {
		logger.info("call url /phoneAlert?firestation={firestation_number}");
		return firestationNumber.firestationNumberPhone(station);
	}

	@JsonView(FloodView.floodView.class)
	@GetMapping(value = "/flood/stations")
	public List<FloodDTO> personAndMedicalInfoByListOfStation(
			@PathParam(value = "stations") List<Integer> stationList) {
		logger.info("call url /flood/stations?stations={a_list_of_station_numbers}");
		return floodService.getPersonAndMedicalInfoByListOfStation(stationList);
	}
}
