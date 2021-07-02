package com.safetyNet.safetyNetAlerts.controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;


/*
 * A terme HttpRequest de la liste Json
 * recuperation de l'objet envoyé dans un JSONArray
 * (File dispo pour test) 
 *
 */
@Component
public class SafetyNetAlertsFileReader {

	@SuppressWarnings("unchecked")
	public void ReadFile() {
		String header1 = null;
		String header2 = null;
		HttpURLConnection connection;
			
			try {
			connection = (HttpURLConnection) new URL(
						"https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json")
								.openConnection();
		
			connection.setRequestMethod("GET");
			// Get Response
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			JSONArray jsonArray = new JSONArray();
			JSONParser parser = new JSONParser(); 
			
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = reader.readLine()) != null) {
			    content.append(inputLine);
			}
			String sContent = content.toString();
			JSONObject json = (JSONObject) parser.parse(sContent);
			
			System.out.println(json);
			reader.close();
			connection.disconnect();
			} catch (MalformedURLException e) {
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
