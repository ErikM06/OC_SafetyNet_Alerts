package com.safetyNet.safetyNetAlerts.DTO;

import java.util.List;

public class FireAddress {
	
	String firstName;
	String lastName;
	String phone;
	String birthdate;
	int station;
	
	public FireAddress(String firstName, String lastName, String phone, String birthdate, int station) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.birthdate = birthdate;
		this.station = station;
	}
	public FireAddress() {
		super();
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public int getStation() {
		return station;
	}
	public void setStation(int station) {
		this.station = station;
	}
	
}
