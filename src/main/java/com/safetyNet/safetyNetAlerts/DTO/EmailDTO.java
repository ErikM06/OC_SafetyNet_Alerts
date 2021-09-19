package com.safetyNet.safetyNetAlerts.DTO;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.Views.EmailView;
import com.safetyNet.safetyNetAlerts.models.Person;

import lombok.Data;

@Component
@Data
public class EmailDTO {
	
	
	@JsonView(EmailView.ViewOnlyEmail.class)
	private Person person;
	
	public EmailDTO() {
		
	}

	public EmailDTO(Person person) {
		super();
		this.person = person;
	}
}
