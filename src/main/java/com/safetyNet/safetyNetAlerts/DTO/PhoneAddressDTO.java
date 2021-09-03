package com.safetyNet.safetyNetAlerts.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.models.View;

@Component
public class PhoneAddressDTO {
	
	@JsonView(View.Public.class)
	public List<PhoneAddress> phoneAddress;

	public List<PhoneAddress> getPhoneAddress() {
		return phoneAddress;
	}

	public void setPhoneAddress(List<PhoneAddress> phoneAddress) {
		this.phoneAddress = phoneAddress;
	}
	
	

}
