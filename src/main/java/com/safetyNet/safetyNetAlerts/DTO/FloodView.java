package com.safetyNet.safetyNetAlerts.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;

@Component
public class FloodView {
	
	@JsonView
	private List<FloodDTO> personAndMedicalInfoByListOfStation;

	public List<FloodDTO> getPersonAndMedicalInfoByListOfStation() {
		return personAndMedicalInfoByListOfStation;
	}

	public void setPersonAndMedicalInfoByListOfStation(List<FloodDTO> personAndMedicalInfoByListOfStation) {
		this.personAndMedicalInfoByListOfStation = personAndMedicalInfoByListOfStation;
	}

	

}
