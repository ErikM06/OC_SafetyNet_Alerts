package com.safetyNet.safetyNetAlerts.controllers;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.safetyNetAlerts.services.SafetyNetAlertsFileReader;

@SpringBootTest
class SafetyNetAlertsFileReaderTest {


	@SuppressWarnings("unchecked")
	@Test
	 void testjsonDataFromUrlToMap() {
		
		SafetyNetAlertsFileReader safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
		Object result = safetyNetAlertsFileReader.jsonDataFromUrl();
		assertNotNull(result);
		


	} 
}
