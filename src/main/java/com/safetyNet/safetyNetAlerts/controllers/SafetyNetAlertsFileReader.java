package com.safetyNet.safetyNetAlerts.controllers;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



@Component
public class SafetyNetAlertsFileReader {

	@SuppressWarnings("unchecked")
	public void ReadFile() {
		String header1 = null;
		String header2 = null;
		URLConnection connection;
			
			try {
			connection = new URL(
						"https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json")
								.openConnection();
			
			connection.setRequestProperty("header1", header1);
			connection.setRequestProperty("header2", header2);
			
			// Get Response
			InputStream is = connection.getInputStream();
			System.out.println(connection.getContentType());
			} catch (MalformedURLException e) {
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
