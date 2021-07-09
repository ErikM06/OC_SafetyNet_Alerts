package com.safetyNet.safetyNetAlerts.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EntitiesController {
	
	
	@RequestMapping (value="/person", method = RequestMethod.GET )
	public void testJson() {
		
		SafetyNetAlertsFileReader alertsFileReader = new SafetyNetAlertsFileReader();
		alertsFileReader.jsonDataFromUrlToMap();
		
		
	}
	public void returnAllEntities() {
		
	}
	
	public void addAnEntity() {
		
	}
	
	public void deleteAnEntity() {
		
	}
	
	public void sortAllEntities () {
		
	}
	
}
