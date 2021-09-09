package com.safetyNet.safetyNetAlerts.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.models.Child;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.models.View;

@Component
public class PersonDTO {
	
	@JsonView(View.Public.class)
	List<Child>childrenByAddress;

	public List<Child> getChildrenByAddress() {
		return childrenByAddress;
	}

	public void setChildrenByAddress(List<Child> childrenByAddress) {
		this.childrenByAddress = childrenByAddress;
	}
	
	@JsonView(View.Public.class)
	List<Person>personByAddress;

	public List<Person> getPersonByAddress() {
		return personByAddress;
	}

	public void setPersonByAddress(List<Person> personByAddress) {
		this.personByAddress = personByAddress;
	}
	
	

}