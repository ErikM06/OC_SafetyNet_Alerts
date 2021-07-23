package com.safetyNet.safetyNetAlerts.config;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootTest
class DataBaseConfigTest {
	
	private static final Logger logger = LogManager.getLogger("DataBaseConfigTest");
	
	@Test
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		logger.info("Opening DB connection");
		Class.forName("org.h2.Driver");
		
		return DriverManager.getConnection("jdbc:h2:mem:testdb","root","rootroot");		
	}
	
	public void closeConnection (Connection con) {
		if (con != null) {
			try {
				con.close();
				logger.info("closing connection");
			}
			catch (SQLException e) {
				logger.info("Error while closing connection",e);
			}
		}
	}

}
