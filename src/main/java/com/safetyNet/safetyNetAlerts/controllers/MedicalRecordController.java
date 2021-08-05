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

import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.services.MedicalRecordService;

@RestController
public class MedicalRecordController {
	
	@Autowired 
	MedicalRecordService medicalRecordService;
	
	@GetMapping ("/medicalRecord")
	private List<MedicalRecord>getAllMedicalRecord (){
		 return medicalRecordService.getAllMedicalRecord();	
	}
	
	@PostMapping (value = "/medicalRecord")
	private int saveMedicalRecord (@RequestBody MedicalRecord medicalRecord) {
		medicalRecordService.saveMedicalRecord(medicalRecord);
		return medicalRecord.getId();
	}
	
	@DeleteMapping (value ="/medicalRecord/{firstname} {lastname}")
	private void deleteMedicalRecord (@PathVariable ("firstname") String firstName, @PathVariable ("lastname") String lastName) {
		medicalRecordService.deleteMedicalRecord(firstName, lastName);
	}
	
	@PutMapping (value ="/medicalRecord/{id}")
	private int modifyMedicalRecord (@RequestBody MedicalRecord medicalRecord, @PathVariable ("id") int id) {
		medicalRecordService.modifyMedicalRecord(medicalRecord, id);
		return medicalRecord.getId();	
	}

}
