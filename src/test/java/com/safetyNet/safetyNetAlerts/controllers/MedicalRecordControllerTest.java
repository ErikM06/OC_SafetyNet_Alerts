package com.safetyNet.safetyNetAlerts.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetyNet.safetyNetAlerts.models.Firestation;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;

@RunWith(SpringRunner.class)
@TestPropertySource("/test.properties")
@SpringBootTest
@AutoConfigureMockMvc
class MedicalRecordControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void getAllMedicalRecord() throws Exception {
		mockMvc.perform(get("/medicalRecord"))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").isNotEmpty());
		
	}
	
	@Test
	public void saveMedicalRecord() throws Exception {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy.MM.dd");
		Date birthdate = fmt.parse("1990.01.01");
		List<String> med = Arrays.asList("MedTest");
		List<String> all = Arrays.asList("Alltest");
		mockMvc.perform(post("/medicalRecord")
				.content(asJsonString(new MedicalRecord("firstName1", "lastName1", birthdate, med, all)))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());	
	}
	
	@Test
	public void deleteMedicalRecord() {
		
	}
	@Test
	public void modifyMedicalRecord() {
		
	}

}
