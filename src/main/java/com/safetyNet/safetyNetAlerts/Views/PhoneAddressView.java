package com.safetyNet.safetyNetAlerts.Views;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.DTO.PhoneAddressDTO;
import com.safetyNet.safetyNetAlerts.models.View;

@Component
public class PhoneAddressView {
	
	@JsonView(View.Public.class)
	public List<PhoneAddressDTO> phoneAddress;

	public List<PhoneAddressDTO> getPhoneAddress() {
		return phoneAddress;
	}

	public void setPhoneAddress(List<PhoneAddressDTO> phoneAddress) {
		this.phoneAddress = phoneAddress;
	}
	
}
