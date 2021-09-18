package com.safetyNet.safetyNetAlerts.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.models.View;

@Component
public class PersonInfoView {
	
	
	public List<PersonInfoDTO>personInfoLs;
	
	public List<PersonInfoDTO> personWithSameLastName;

	public List<PersonInfoDTO> getPersonInfoLs() {
		return personInfoLs;
	}

	public void setPersonInfoLs(List<PersonInfoDTO> personInfoLs) {
		this.personInfoLs = personInfoLs;
	}

	public List<PersonInfoDTO> getPersonWithSameLastName() {
		return personWithSameLastName;
	}

	public void setPersonWithSameLastName(List<PersonInfoDTO> personWithSameLastName) {
		this.personWithSameLastName = personWithSameLastName;
	}

}
