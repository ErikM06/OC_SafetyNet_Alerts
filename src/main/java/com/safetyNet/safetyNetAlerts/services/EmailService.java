package com.safetyNet.safetyNetAlerts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.EmailView;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@Service
public class EmailService {
	
	@Autowired
	EmailView emailView;
	
	@Autowired
	PersonRepository personRepository;
	
	public EmailView getCommunityEmail (String city) {
		
		emailView.setGetAllEmail(personRepository.getAllEmailFromCity(city));
		
		return emailView;
		
	}

}
