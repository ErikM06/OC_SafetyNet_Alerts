package com.safetyNet.safetyNetAlerts.DTO;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.safetyNet.safetyNetAlerts.models.MedicalRecord;

@Component
public class FireAddressDTO {
	
	@Id
	private int id;
	private MedicalRecord medicalRecordLs;
	private String address;
	private String phone;
	private int station;
	
	public FireAddressDTO() {
	
	}

	public FireAddressDTO(MedicalRecord medicalRecordLs, String address, String phone,int station) {
		super();
		this.medicalRecordLs = medicalRecordLs;
		this.address = address;
		this.phone = phone;
		this.station = station;
	}
	
	
	public MedicalRecord getMedicalRecordLs() {
		return medicalRecordLs;
	}

	public void setMedicalRecordLs(MedicalRecord medicalRecordLs) {
		this.medicalRecordLs = medicalRecordLs;
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
