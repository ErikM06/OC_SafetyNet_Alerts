package com.safetyNet.safetyNetAlerts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.EmailDTO;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@Service
public class EmailService {
	
	
	
	@Autowired
	PersonRepository personRepository;
	
	public List<EmailDTO> getCommunityEmail (String city) {
		
		List<EmailDTO> emailDTOls = (personRepository.getAllEmailFromCity(city));
		
		return emailDTOls;
		
	}

}
