package com.safetyNet.safetyNetAlerts.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ChildAlertServiceTest {
	
	@MockBean
	PersonRepository personRepository;
	
	@Autowired
	ChildAlertService childAlertService;

	@Test
	void testChildAlterService() {
		fail("Not yet implemented");
	}

}
