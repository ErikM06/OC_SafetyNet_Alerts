package com.safetyNet.safetyNetAlerts.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;



@Component
public class Child {
	
	@Id
	
	int id;
	String firstName;
	String lastName;
	Date birthdate;
	
	
	public Child() {
		super();
	}

	public Child(String firstName, String lastName, Date birthdate) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
