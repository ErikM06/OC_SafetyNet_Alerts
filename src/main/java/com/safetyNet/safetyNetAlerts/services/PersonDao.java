package com.safetyNet.safetyNetAlerts.services;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.models.Root;

@Component
public class PersonDao {

	SafetyNetAlertsFileReader safetyNetAlertsFileReader;
	Root root;
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:mem:testdb";

	public void personToTable() {

		Connection conn = null;
		int id = 0;

		safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
		Root jsonObjet = safetyNetAlertsFileReader.jsonDataFromUrl();

		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, "root", "rootroot");
			List<Person> personsLs = jsonObjet.persons;
			System.out.println(personsLs);

			PreparedStatement prepSt = conn
					.prepareStatement("INSERT INTO person (id, first_Name, last_Name, address, city, zip, phone, email) "
							+ " VALUE (?,?,?,?,?,?,?,?) ");

			for (Object object : personsLs) {
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
	}
}
