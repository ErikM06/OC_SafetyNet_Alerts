package com.safetyNet.safetyNetAlerts.Views;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.DTO.ChildAlertDTO;
import com.safetyNet.safetyNetAlerts.models.Person;

@Component
public class ChildAlertView {
	
	@JsonView
	List<ChildAlertDTO>childrenByAddress;

	public List<ChildAlertDTO> getChildrenByAddress() {
		return childrenByAddress;
	}

	public void setChildrenByAddress(List<ChildAlertDTO> childrenByAddress) {
		this.childrenByAddress = childrenByAddress;
	}
	
	@JsonView
	List<Person>personByAddress;

	public List<Person> getPersonByAddress() {
		return personByAddress;
	}

	public void setPersonByAddress(List<Person> personByAddress) {
		this.personByAddress = personByAddress;
	}
		
}
