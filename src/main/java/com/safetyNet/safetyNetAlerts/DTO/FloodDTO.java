package com.safetyNet.safetyNetAlerts.DTO;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.safetyNet.safetyNetAlerts.models.MedicalRecord;

@Component
public class FloodDTO {

	@Id
	private int id;
	private String address;
	private String phone;
	private MedicalRecord medicalRecord;
	
	public FloodDTO () {
		
	}
	
	public FloodDTO(String address, String phone, MedicalRecord medicalRecord) {
		super();
		this.address = address;
		this.phone = phone;
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
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

}
