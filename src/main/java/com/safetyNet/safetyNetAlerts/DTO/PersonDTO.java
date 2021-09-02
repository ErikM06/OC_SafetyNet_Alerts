package com.safetyNet.safetyNetAlerts.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.models.View;

@Component
public class PersonDTO {
	
	@JsonView(View.Public.class)
	List<Person>childrenByAddress;

	public List<Person> getChildrenByAddress() {
		return childrenByAddress;
	}

	public void setChildrenByAddress(List<Person> childrenByAddress) {
		this.childrenByAddress = childrenByAddress;
	}
	
	@JsonView(View.Public.class)
	List<Person>PersonByAddress;

	public List<Person> getPersonByAddress() {
		return PersonByAddress;
	}

	public void setPersonByAddress(List<Person> personByAddress) {
		PersonByAddress = personByAddress;
	}
	
	

}
