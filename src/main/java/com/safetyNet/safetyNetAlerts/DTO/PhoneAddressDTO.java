package com.safetyNet.safetyNetAlerts.DTO;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.Views.PhoneAddressView;
import com.safetyNet.safetyNetAlerts.models.Person;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class PhoneAddressDTO {

	@Id
	private int id;
	@JsonView(PhoneAddressView.PhoneAddressViewForPerson.class)
	private Person person;

	public PhoneAddressDTO() {

	}

	public PhoneAddressDTO(Person person) {
		super();
		this.person = person;
	}

}
