package com.safetyNet.safetyNetAlerts.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "allergies")
public class Allergies {
	
	private int id;
	@Column
	private String allergie;
	
	@Id
	@GeneratedValue
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAllergie() {
		return allergie;
	}
	public void setAllergie(String allergie) {
		this.allergie = allergie;
	}
	

}
