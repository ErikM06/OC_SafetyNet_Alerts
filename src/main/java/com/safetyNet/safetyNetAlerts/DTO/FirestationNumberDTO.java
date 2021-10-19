package com.safetyNet.safetyNetAlerts.DTO;

import java.util.List;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.Views.FirestationNumberView;
import com.safetyNet.safetyNetAlerts.models.Person;

@Component
public class FirestationNumberDTO {

	@Id

	private int id;
	@JsonView(FirestationNumberView.personInfoView.class)
	private List<Person> persons;
	@JsonView(FirestationNumberView.numberChildAndAdults.class)
	private Integer nbAdults;
	@JsonView(FirestationNumberView.numberChildAndAdults.class)
	private Integer nbChildren;

	public Integer getNbChildren() {
		return nbChildren;
	}

	public void setNbChildren(Integer nbChildren) {
		this.nbChildren = nbChildren;
	}

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
