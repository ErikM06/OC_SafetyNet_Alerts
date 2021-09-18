package com.safetyNet.safetyNetAlerts.DTO;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.Views.FireAddressView;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;

@Component
public class FireAddressDTO {
	
	@Id
	private int id;
	@JsonView(FireAddressView.fireAddressView.class)
	private MedicalRecord medicalRecord;
	@JsonView(FireAddressView.fireAddressView.class)
	private String address;
	@JsonView(FireAddressView.fireAddressView.class)
	private String phone;
	@JsonView(FireAddressView.fireAddressView.class)
	private int station;
	
	public FireAddressDTO() {
	
	}

	public FireAddressDTO(MedicalRecord medicalRecord, String address, String phone,int station) {
		super();
		this.medicalRecord = medicalRecord;
		this.address = address;
		this.phone = phone;
		this.station = station;
	}
	
	
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

}
