package com.safetyNet.safetyNetAlerts.controllers;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.safetyNet.safetyNetAlerts.services.SafetyNetAlertsFileReader;

@RunWith(SpringRunner.class)
@TestPropertySource("/test.properties")
@SpringBootTest
class SafetyNetAlertsFileReaderTest {

	@Test
	void testjsonDataFromUrlToMap() {

		SafetyNetAlertsFileReader safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
		Object result = safetyNetAlertsFileReader.jsonDataFromUrl();
		assertNotNull(result);

	}
}
