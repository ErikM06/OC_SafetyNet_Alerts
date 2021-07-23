package com.safetyNet.safetyNetAlerts.models;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;


@ Entity
public class Firestation {

	public Firestation () {
		super();
	}
	public Firestation(int id, String address, String station) {
		
		this.id = id;
		this.address = address;
		this.station = station;
	}
	@Id
	@GeneratedValue
	private int id;
	private String address;
    private String station;
    
    @Column (name="Id", nullable = false, length = 512)
    public int getId() {
 		return id;
 	}
 	public void setId(int id) {
 		this.id = id;
 	}
 	
    @Column (name="Adresse", nullable =  false, length = 512)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="Station", nullable = false, length = 512)
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	

}
