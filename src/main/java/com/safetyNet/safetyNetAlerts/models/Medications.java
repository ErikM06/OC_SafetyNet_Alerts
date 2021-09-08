package com.safetyNet.safetyNetAlerts.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table (name ="medications")
public class Medications {
	
	@Id
	@GeneratedValue
	
	private int id;
	@Column
	@ElementCollection(targetClass = String.class)
	private List<String> medications;
	

	public Medications() {
		super();
		
	}
	public Medications(List<String> medications) {
		super();
		this.medications = medications;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getMedications() {
		return medications;
	}
	public void setMedications(List<String> medications) {
		this.medications = medications;
	}
	
	
}
