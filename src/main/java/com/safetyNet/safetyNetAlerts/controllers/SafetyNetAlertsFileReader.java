package com.safetyNet.safetyNetAlerts.controllers;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
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
	public Map<String, Object> jsonDataFromUrlToMap() {

		HttpURLConnection connection;
		String url = "https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json";
		Map<String, Object> jsonMap = null;
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

	@SuppressWarnings("static-access")
	public void setUpDataSQLFromJsonMap() {
		FileOutputStream fOut;
		
		
		try {
			Path path = Paths.get("C:/dev/P5/Projet 5/safetyNetAlerts/src/main/resources/data");
			Path tempFile = Files.createTempFile(path, null, ".sql");
			String strPath = path.toString();
		
			fOut = new FileOutputStream(strPath);
			SafetyNetAlertsFileReader safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
			Map<String, Object> mapToFile = new HashMap<String, Object>();

			ObjectOutputStream out = new ObjectOutputStream(fOut);
			out.writeObject(mapToFile);

			out.close();
			fOut.close();
		} catch (

		FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
