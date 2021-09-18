package com.safetyNet.safetyNetAlerts.Views;



import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.models.View;

@Component
public class FirestationNumberView {

	
	@JsonView (View.Public.class)
	Integer nbChildren;
	
	public Integer getNbChildren() {
		return nbChildren;
	}

	public void setNbChildren(Integer nbChildren) {
		this.nbChildren = nbChildren;
	}
	
	@JsonView (View.Public.class)
	Integer nbAdults;
	
	public Integer getNbAdults () {
		return nbAdults;
		
	}
	public void setNbAdults (Integer nbAdults) {
		this.nbAdults = nbAdults;
	}

	@JsonView (View.Public.class)
	List<Person>persons;
	
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
}
