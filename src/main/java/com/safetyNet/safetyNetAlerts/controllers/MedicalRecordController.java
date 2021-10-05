package com.safetyNet.safetyNetAlerts.controllers;

import java.util.List;
import java.util.Optional;

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

import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.repositories.MedicalRecordRepository;
import com.safetyNet.safetyNetAlerts.services.MedicalRecordService;

@RestController
public class MedicalRecordController {
	
	@Autowired 
	MedicalRecordService medicalRecordService;
	
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	
	@GetMapping ("/medicalRecord")
	private List<MedicalRecord>getAllMedicalRecord (){
		 return medicalRecordService.getAllMedicalRecord();	
	}
	
	@PostMapping (value = "/medicalRecord")
	private ResponseEntity<MedicalRecord> saveMedicalRecord (@RequestBody MedicalRecord medicalRecord) {
		medicalRecordService.saveMedicalRecord(medicalRecord);
		return new ResponseEntity<MedicalRecord>(medicalRecord, HttpStatus.CREATED);
	}
	
	@DeleteMapping (value ="/medicalRecord/{firstname} {lastname}")
	private ResponseEntity<HttpStatus> deleteMedicalRecord (@PathVariable ("firstname") String firstName, @PathVariable ("lastname") String lastName) {
		medicalRecordService.deleteMedicalRecord(firstName, lastName);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping (value ="/medicalRecord/update/{id}")
	private ResponseEntity<MedicalRecord> modifyMedicalRecord (@RequestBody MedicalRecord medicalRecord, @PathVariable ("id") int id) {
		Optional<MedicalRecord> firestationOptional = medicalRecordRepository.findById(id);
		if (!firestationOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		medicalRecordService.modifyMedicalRecord(medicalRecord, id);
		medicalRecordService.saveMedicalRecord(medicalRecord);
		return ResponseEntity.noContent().build();	
	}

}
