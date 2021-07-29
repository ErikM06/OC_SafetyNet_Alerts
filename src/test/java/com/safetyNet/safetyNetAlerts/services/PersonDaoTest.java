package com.safetyNet.safetyNetAlerts.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;



import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.models.Root;

@SpringBootTest
class PersonDaoTest {

	SafetyNetAlertsFileReader safetyNetAlertsFileReader;
	Root root;
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:mem:testdb";

	@SuppressWarnings("static-access")
	@Test
	void personToTableTest() throws JsonParseException {

		Connection conn = null;

		safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
		Root jsonObject = safetyNetAlertsFileReader.jsonDataFromUrl();

		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, "root", "rootroot");

			List<Person> personsJsAr = jsonObject.persons;
			System.out.println(personsJsAr);
			JSONArray jsonArray = new JSONArray(personsJsAr);
			
			JSONObject record = new JSONObject();
			record = jsonArray.toJSONObject(jsonArray);
			
			

			PreparedStatement prepSt = conn.prepareStatement(
					"INSERT INTO person (id, First_Name, last_Name, address, city, zip, phone, email) "
							+ " VALUES(?,?,?,?,?,?,?,?)");
			
			String firstName = record.getString("firstName");
			String lastName = record.getString("lastName");
			String address = record.getString("address");
			String city = record.getString("city");
			int zip = record.getInt("zip");
			int phone = record.getInt("phone");
			String email = record.getString("email");
			/*
			 * for (Object object : result) { JSONObject record = object;
			 * 
			 * int id = 0; id++; String firstName = (String) record.get("firstName"); String
			 * lastName = (String) record.get("lastName"); String address = (String)
			 * record.get("adresse"); String city = (String) record.get("city"); String zip
			 * = (String) record.get("zip"); String phone = (String) record.get("phone");
			 * String email = (String) record.get("email");
			 */

			prepSt.setString(1, firstName);
			prepSt.setString(2, lastName);
			prepSt.setString(3, address);
			prepSt.setString(4, city);
			prepSt.setLong(5, zip);
			prepSt.setLong(6, phone);
			prepSt.setString(7, email);

			prepSt.executeUpdate();

		} catch (

		ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
