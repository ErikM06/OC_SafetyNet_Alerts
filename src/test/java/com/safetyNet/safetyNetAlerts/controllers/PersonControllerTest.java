package com.safetyNet.safetyNetAlerts.controllers;

import static org.junit.jupiter.api.Assertions.*;
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
import com.safetyNet.safetyNetAlerts.models.Person;

@RunWith(SpringRunner.class)
@TestPropertySource("/test.properties")
@SpringBootTest
@AutoConfigureMockMvc

class PersonControllerTest {
	
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
	public void testGetAllPerson() throws Exception {
		mockMvc.perform(get("/person"))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].address").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].address").isNotEmpty());
	}
	
	@Test
	public void testDeletePerson() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/person/John Boyd")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted());
		
	}
	
	@Test
	public void testSavePerson() throws Exception {
		mockMvc.perform(post("/person")
				.content(asJsonString(new Person("firstNameTest", "lastNameTest", "addressTest", "cityTest", "zipTest", "phoneTest", "emailTest")))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
		
	}
	
	@Test
	public void testModifyPerson () throws Exception {
		 mockMvc.perform( MockMvcRequestBuilders
			      .put("/person/update/{id}", 1)
			      .content(asJsonString(new Person("firstNameTest", "lastNameTest", "addressTest", "cityTest", "zipTest", "phoneTest", "emailTest")))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
		
	}
	
	@Test
	 public void TestChildAltert() throws Exception {
		mockMvc.perform(get("/childAlert/address=/1509 Culver S"))
		.andExpect(status().isOk());
	}
	

	@Test
	public void TestCommunityEmail() throws Exception {
		mockMvc.perform(get("/communityEmail/city=Culver"))
		.andExpect(status().isOk());
	}
	

	@Test
	public void TestFireAddress () throws Exception {
		mockMvc.perform(get("/fire/address=/1509 Culver S"))
		.andExpect(status().isOk());
	}
	

	@Test
	public void TestPersonInfo() throws Exception {
		mockMvc.perform(get("/personInfo/firstName=John&lastName=Boyd"))
		.andExpect(status().isOk());
	}
	

}
