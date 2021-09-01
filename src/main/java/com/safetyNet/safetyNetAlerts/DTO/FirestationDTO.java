package com.safetyNet.safetyNetAlerts.DTO;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.models.View;


public class FirestationDTO {

	@JsonView (View.Public.class)
	Integer nbAdults;
	
	@JsonView (View.Public.class)
	Integer nbChildren;
	
	public Integer getNbChildren() {
		return nbChildren;
	}

	public void setNbChildren(Integer nbChildren) {
		this.nbChildren = nbChildren;
	}

	@JsonView (View.Public.class)
	List<Person>persons;

	public Integer getNbAdults() {
		return nbAdults;
	}

	public void setNbAdults(Integer nbAdults) {
		this.nbAdults = nbAdults;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
}
