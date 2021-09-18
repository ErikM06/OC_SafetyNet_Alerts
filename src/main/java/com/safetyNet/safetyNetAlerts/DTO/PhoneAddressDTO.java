package com.safetyNet.safetyNetAlerts.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.Views.PhoneAddressView;
import com.safetyNet.safetyNetAlerts.models.Person;

public class PhoneAddressDTO {
	
	@JsonView(PhoneAddressView.PhoneAddressViewForPerson.class)
	Person person;
	
	public PhoneAddressDTO() {
		
	}
	
	public PhoneAddressDTO(Person person) {
		super();
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	
	
	
	
}
