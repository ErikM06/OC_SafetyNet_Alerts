package com.safetyNet.safetyNetAlerts.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.safetyNetAlerts.models.Entities;


@RestController
public class EntitiesDaoImple implements IEntitiesDao {
	
	
	private static Entities entities = new Entities(null, null, null, null);

	
	public void findAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findById() {
		// TODO Auto-generated method stub
		
	}

	@PostMapping (value = "/person")
	public void save() {
		
		
		
	}

}
