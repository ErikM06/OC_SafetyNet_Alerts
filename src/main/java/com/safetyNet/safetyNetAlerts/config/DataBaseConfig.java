package com.safetyNet.safetyNetAlerts.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class DataBaseConfig {

	private static final Logger logger = LogManager.getLogger("DataBaseConfigTest");

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		logger.info("Opening DB connection");
		Class.forName("jdbc:h2:mem:testdb");

		return DriverManager.getConnection("http://localhost:8080/h2-console", "root", "rootroot");
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
