package com.safetyNet.safetyNetAlerts.controllers;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/*
 * A terme HttpRequest de la liste Json
 * recuperation de l'objet envoyé dans un JSONArray
 * (File dispo pour test) 
 *
 */
@Component
public class SafetyNetAlertsFileReader {

	
	@SuppressWarnings("unchecked")
	public Map <String, String> jsonDataFromUrlToMap() {

		HttpURLConnection connection;
		String url = "https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json";
		Map<String, String> jsonMap = null;
		try {
			connection = (HttpURLConnection) new URL(url).openConnection();

			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();

			if (responseCode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responseCode);

			} else {

				ObjectMapper mapper = new ObjectMapper();
				jsonMap = mapper.readValue(new URL(url), Map.class);

				System.out.println(jsonMap);
			}
			connection.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}
}
