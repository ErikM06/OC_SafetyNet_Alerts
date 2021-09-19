package com.safetyNet.safetyNetAlerts.Views;



import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.models.Person;


@Component
public class FirestationNumberView {

	
	@JsonView 
	Integer nbChildren;
	
	public Integer getNbChildren() {
		return nbChildren;
	}

	public void setNbChildren(Integer nbChildren) {
		this.nbChildren = nbChildren;
	}
	
	@JsonView 
	Integer nbAdults;
	
	public Integer getNbAdults () {
		return nbAdults;
		
	}
	public void setNbAdults (Integer nbAdults) {
		this.nbAdults = nbAdults;
	}

	@JsonView 
	List<Person>persons;
	
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
}
