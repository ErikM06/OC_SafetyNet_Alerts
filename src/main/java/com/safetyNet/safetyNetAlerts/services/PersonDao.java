package com.safetyNet.safetyNetAlerts.services;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.safetyNet.safetyNetAlerts.config.DataBaseConfig;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.models.Root;
import com.safetyNet.safetyNetAlerts.repositories.PersonRepository;


public class PersonDao  {
	
	private PersonRepository IPersonDAO;
	
	
	@Autowired
	public PersonDao (PersonRepository IPersonDao) {
		this.IPersonDAO=IPersonDAO;
		
	}
	DataBaseConfig dataBaseConfig;
	SafetyNetAlertsFileReader safetyNetAlertsFileReader;
	Root root;
	
	public void personToTable(){
		
		
		int id = 0;
		Connection conn = null;
		dataBaseConfig = new DataBaseConfig();
		safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
		Root jsonObjet = safetyNetAlertsFileReader.jsonDataFromUrl();
		
		try {
			conn = dataBaseConfig.getConnection();
			
			List<Person>personsLs = jsonObjet.persons;
			System.out.println(personsLs);
		
			PreparedStatement prepSt = conn.prepareStatement("INSERT INTO person (id, firstName, lastName, adress, city, zip, phone, email) "
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
		dataBaseConfig.closeConnection(conn);
	}
}
