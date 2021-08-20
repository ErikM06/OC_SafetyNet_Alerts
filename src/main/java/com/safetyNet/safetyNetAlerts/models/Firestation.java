package com.safetyNet.safetyNetAlerts.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Firestation {

	
	@Id
	@GeneratedValue
	private int id;
	private String address;
    private int station;
    
    public Firestation () {
		super();
	}
	public Firestation( String address, int station) {
		
		this.address = address;
		this.station = station;
	}
    
    public int getId() {
 		return id;
 	}
 	public void setId(int id) {
 		this.id = id;
 	}
 	
    @Column (name="Address", nullable =  false, length = 512)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="Station", nullable = false, length = 512)
	public int getStation() {
		return station;
	}
	public void setStation(int station) {
		this.station = station;
	}
	

}
