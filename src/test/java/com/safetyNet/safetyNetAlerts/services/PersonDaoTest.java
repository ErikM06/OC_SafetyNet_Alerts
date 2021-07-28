package com.safetyNet.safetyNetAlerts.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.models.Root;

@SpringBootTest
class PersonDaoTest {

	
	SafetyNetAlertsFileReader safetyNetAlertsFileReader;
	Root root;
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:mem:testdb";

	@Test
	void personToTableTest() {

		Connection conn = null;

		safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
		Root jsonObjet = safetyNetAlertsFileReader.jsonDataFromUrl();

		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, "root", "rootroot");

			List<Person> personsLs = jsonObjet.persons;
			System.out.println(personsLs);

			PreparedStatement prepSt = conn
					.prepareStatement("INSERT INTO person (id, First_Name, last_Name, address, city, zip, phone, email) "
							+ " VALUES(?,?,?,?,?,?,?,?)");

			for (Object object : personsLs) {
				JSONObject record = object;

				int id = 0;
						id++;
				String firstName = (String) record.get("firstName");
				String lastName = (String) record.get("lastName");
				String address = (String) record.get("adresse");
				String city = (String) record.get("city");
				String zip = (String) record.get("zip");
				String phone = (String) record.get("phone");
				String email = (String) record.get("email");
				prepSt.setInt(1, id);
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
