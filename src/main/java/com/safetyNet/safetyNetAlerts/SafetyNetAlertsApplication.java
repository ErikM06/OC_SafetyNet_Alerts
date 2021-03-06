package com.safetyNet.safetyNetAlerts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SafetyNetAlertsApplication {

	private static final Logger logger = LogManager.getLogger(SafetyNetAlertsApplication.class);

	public static void main(String[] args) {
		logger.info("Starting the application");
		SpringApplication.run(SafetyNetAlertsApplication.class, args);
	}
}
