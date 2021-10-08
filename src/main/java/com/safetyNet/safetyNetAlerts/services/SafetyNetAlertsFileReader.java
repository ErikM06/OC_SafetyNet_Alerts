package com.safetyNet.safetyNetAlerts.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetyNet.safetyNetAlerts.models.Root;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * A terme HttpRequest de la liste Json
 * recuperation de l'objet envoyé dans un JSONArray
 * (File dispo pour test) 
 *
 */
@Component
public class SafetyNetAlertsFileReader {
	
	private static final Logger logger = LoggerFactory.getLogger(SafetyNetAlertsFileReader.class);

	public Root jsonDataFromUrl() {

		HttpURLConnection connection;
		String url = "https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json";
		Root jsonObject = null;
		try {
			connection = (HttpURLConnection) new URL(url).openConnection();

			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();

			if (responseCode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responseCode);

			} else {

				ObjectMapper mapper = new ObjectMapper();
				jsonObject = mapper.readValue(new URL(url), Root.class);

				System.out.println(jsonObject);
			}
			connection.disconnect();
		} catch (MalformedURLException e) {	
			e.printStackTrace();
			logger.error("Unable to reach Url ", e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Unable to reach the file ",e);
		}
		return jsonObject;
	}
}
