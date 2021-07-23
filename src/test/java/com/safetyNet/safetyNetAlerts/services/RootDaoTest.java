package com.safetyNet.safetyNetAlerts.services;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStreamReader;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safetyNet.safetyNetAlerts.config.DataBaseConfig;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.models.Root;

class RootDaoTest {

	DataBaseConfig dataBaseConfig;
	SafetyNetAlertsFileReader safetyNetAlertsFileReader;
	Root root;

	@Test
	void testInsertDao() {

		int i = 0;
		int id = 0;
		Connection conn = null;
		dataBaseConfig = new DataBaseConfig();
		safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
		Root jsonObjet = safetyNetAlertsFileReader.jsonDataFromUrl();

		try {

			conn = dataBaseConfig.getConnection();

			List<Person> personsLs = jsonObjet.persons;
			System.out.println(personsLs);
			
			//Gson builder in pom dep for Object to json 
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String jsonObject = gson.toJson(personsLs);
			

			JSONArray jsonArray = (JSONArray)jsonObject.get("persons");
			PreparedStatement prepSt = conn.prepareStatement("INSERT INTO person VALUE (?,?,?,?,?,?,?,?) ");

			for (Object object : jsonArray) {
				JSONObject record = (JSONObject) object;
				while (personsLs != null) {
					id++;
					prepSt.setInt(1, id);
				}
				String firstName = (String) record.get("firstName");
				String lastName = (String) record.get("lastName");
				String address = (String) record.get("adresse");
				String city = (String) record.get("city");
				String zip = (String) record.get("zip");
				String phone = (String) record.get("phone");
				String email = (String) record.get("email");
				prepSt.setString(2, firstName);
				prepSt.setString(3, lastName);
				prepSt.setString(4, address);
				prepSt.setString(5, city);
				prepSt.setString(6, zip);
				prepSt.setString(7, phone);
				prepSt.setString(8, email);

				prepSt.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataBaseConfig.closeConnection(conn);
	}

}
