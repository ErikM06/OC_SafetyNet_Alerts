package com.safetyNet.safetyNetAlerts.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmailView {
	
	public List<EmailDTO> getAllEmail;

	public List<EmailDTO> getGetAllEmail() {
		return getAllEmail;
	}

	public void setGetAllEmail(List<EmailDTO> getAllEmail) {
		this.getAllEmail = getAllEmail;
	}

}
