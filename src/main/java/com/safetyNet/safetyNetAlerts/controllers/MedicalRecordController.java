package com.safetyNet.safetyNetAlerts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.safetyNetAlerts.services.MedicalRecordService;

@RestController
public class MedicalRecordController {
	
	@Autowired 
	MedicalRecordService medicalRecordService;

}
