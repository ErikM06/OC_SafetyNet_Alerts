package com.safetyNet.safetyNetAlerts.DTO;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;

@Component
public class EmailDTO {
	
	
	@JsonView(EmailView.ViewOnlyEmail.class)
	String email;
	@JsonView(EmailView.ViewAllInfo.class)
	String firstname;
	@JsonView(EmailView.ViewAllInfo.class)
	String lastname;
	
	public EmailDTO() {
		super();
	}
	public EmailDTO(String email, String firstname, String lastname) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
