package com.safetyNet.safetyNetAlerts.DTO;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.Views.EmailView;
import com.safetyNet.safetyNetAlerts.models.Person;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class EmailDTO {

	@Id
	private int id;
	@JsonView(EmailView.View.class)
	private Person person;

	public EmailDTO() {

	}

	public EmailDTO(Person person) {
		super();
		this.person = person;
	}
}
