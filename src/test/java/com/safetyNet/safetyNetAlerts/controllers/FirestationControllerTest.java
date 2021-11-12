package com.safetyNet.safetyNetAlerts.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.safetyNet.safetyNetAlerts.models.Firestation;

@RunWith(SpringRunner.class)
@TestPropertySource("/test.properties")
@SpringBootTest
@AutoConfigureMockMvc
public class FirestationControllerTest {

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
	public void testGetAllFirestations() throws Exception {
		mockMvc.perform(get("/firestation")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].address").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].address").isNotEmpty());
		mockMvc.perform(get("/firestation?stationNumber=1")).andExpect(status().isOk());
	}

	@Test
	public void testSaveFirestation() throws Exception {
		mockMvc.perform(post("/firestation").content(asJsonString(new Firestation("address1", 1)))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());

	}

	@Test
	public void deleteFirestation() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/firestation/50").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isAccepted());
	}

	@Test
	public void modifyFirestationNumber() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/firestation/update/{id}", 49)
				.content(asJsonString(new Firestation("644 Gershwin Cir", 8))).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}

	@Test
	public void testFindClosestStationPerHabitant() throws Exception {
		mockMvc.perform(get("/firestation?stationNumber=1")).andExpect(status().isOk());
	}

	@Test
	public void testFirestationNumber() throws Exception {
		mockMvc.perform(get("/phoneAlert?firestation=1")).andExpect(status().isOk());
	}

	@Test
	public void testPersonAndMedicalInfoByListOfStation() throws Exception {
		mockMvc.perform(get("/flood/stations?stations=1,2,3" )).andExpect(status().isOk());		
	}

}
