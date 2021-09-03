package com.safetyNet.safetyNetAlerts.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.models.View;

@Component
public class FireAddressDTO {
	
	@JsonView(View.Public.class)
	List<FireAddress> FnLnPhoneAddressBirthdate;
	
	@JsonView(View.Public.class)
	List<String> medications;
	
	@JsonView(View.Public.class)
	List<String> allergies;

	public List<FireAddress> getFnLnPhoneAddressBirthdate() {
		return FnLnPhoneAddressBirthdate;
	}

	public void setFnLnPhoneAddressBirthdate(List<FireAddress> fnLnPhoneAddressBirthdate) {
		FnLnPhoneAddressBirthdate = fnLnPhoneAddressBirthdate;
	}

	public List<String> getMedications() {
		return medications;
	}

	public void setMedications(List<String> medications) {
		this.medications = medications;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

}
