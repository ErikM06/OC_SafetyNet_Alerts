package com.safetyNet.safetyNetAlerts.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import org.junit.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetyNet.safetyNetAlerts.models.Root;

@Component
class SafetyNetAlertsFileReaderTest {

	private SafetyNetAlertsFileReader safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
	Root jsonMap;

	@Test
	void testJsonDataFromUrlToMap() {

		jsonMap = safetyNetAlertsFileReader.jsonDataFromUrlToMap();
		assertFalse(jsonMap.isEmpty());

	}

	/* @SuppressWarnings("unchecked")
	@Test
	 void testsetUpDataSQLFromJsonMap() {
		
		Map<String, Object> compareMap = null;
		File jsonToSqlFile = new File("C:/dev/P5/Projet 5/safetyNetAlerts/src/main/resources/data.sql");
		safetyNetAlertsFileReader.setUpDataSQLFromJsonMap(jsonMap);
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(jsonToSqlFile));
			ObjectMapper mapper = new ObjectMapper();
			compareMap = mapper.readValue(jsonToSqlFile, Map.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			assertEquals(jsonMap, compareMap);
		}

	} */

}
