package com.safetyNet.safetyNetAlerts.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.safetyNet.safetyNetAlerts.config.DataBaseConfig;
import com.safetyNet.safetyNetAlerts.models.Person;
import com.safetyNet.safetyNetAlerts.models.Root;

class RootDaoTest {
	
	DataBaseConfig dataBaseConfig;
	SafetyNetAlertsFileReader safetyNetAlertsFileReader;
	Root root;

	@Test
	void testInsertDao() {

		Connection conn = null;
		safetyNetAlertsFileReader = new SafetyNetAlertsFileReader();
		Root jsonObjet = safetyNetAlertsFileReader.jsonDataFromUrl();

		try {
			conn = dataBaseConfig.getConnection();
			List<Person> personsLs = jsonObjet.persons;
			System.out.println(personsLs);
			Object personsAr = personsLs.toArray();
			PreparedStatement prepSt = conn.prepareStatement("INSERT INTO person VALUE ? ");
			prepSt.setArray(1, (Array) personsAr);

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
