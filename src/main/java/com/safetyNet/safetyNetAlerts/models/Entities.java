package com.safetyNet.safetyNetAlerts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity

public class Entities {
	@Id
	@GeneratedValue

	private int id;

	private String name;
	private String lastname;
	private String address;
	private String city;
	private String email;
	private String medication;
	private int zip;
	private int phone;
	private int station;
	private int birthdayDate;

	public Entities(int id, String name, String lastname, String address, String city) {
		id = this.id;
		name = this.name;
		lastname = this.lastname;
		address = this.address;
		city = this.city;
	}

	@Override
	public String toString() {
		return "Entities {" + "id=" + id + ", name=" + name + '\''
				+ ", lastname=" + lastname + ", address=" + address + '\'' 
				+ ", city=" + city + "}";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAdresse() {
		return address;
	}

	public void setAdresse(String adresse) {
		this.address = adresse;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

	public int getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(int birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

}
