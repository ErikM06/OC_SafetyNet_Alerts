package com.safetyNet.safetyNetAlerts.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.NullArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.safetyNetAlerts.DTO.EmailDTO;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@Service
public class EmailService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	@Autowired
	PersonRepository personRepository;
	
	public List<EmailDTO> getCommunityEmail (String city) {
		List<EmailDTO> emailDTOls = new ArrayList<>();
		try {
		emailDTOls = personRepository.getAllEmailFromCity(city);
		} catch (NullPointerException|NullArgumentException e) {
			logger.error("Unable to set emailDTO ", e);
		}
		return emailDTOls;
	}

}
