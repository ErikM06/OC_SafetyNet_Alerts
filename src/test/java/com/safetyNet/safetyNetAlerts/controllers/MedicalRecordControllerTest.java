package com.safetyNet.safetyNetAlerts.controllers;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
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
		mockMvc.perform(get("/medicalRecord")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").isNotEmpty());

	}

	@Test
	public void saveMedicalRecord() throws Exception {
		String birthdate = "03/06/1984";
		Date date = new SimpleDateFormat("MM/dd/yyyy").parse(birthdate);
		List<String> med = Arrays.asList("MedTest");
		List<String> all = Arrays.asList("Alltest");
		MedicalRecord medicalRecord = new MedicalRecord("firstName1", "lastName1", date, med, all);
		mockMvc.perform(post("/medicalRecord").content(asJsonString(medicalRecord))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	public void deleteMedicalRecord() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/medicalRecord/John Boyd")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted());

	}

	@Test
	public void modifyMedicalRecord() throws Exception {
		String birthdate = "01/08/2011";
		Date date = new SimpleDateFormat("MM/dd/yyyy").parse(birthdate);
		List<String> med = Arrays.asList("MedTest");
		List<String> all = Arrays.asList("Alltest");
		mockMvc.perform(MockMvcRequestBuilders.put("/medicalRecord/update/{id}", 41)
				.content(asJsonString(new MedicalRecord("firstnameTest", "lastNameTest", date, med, all)))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

}
