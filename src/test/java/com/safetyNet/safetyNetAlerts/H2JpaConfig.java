package com.safetyNet.safetyNetAlerts;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

 @Configuration
@EnableJpaRepositories 
@PropertySource("classpath:h2Test.properties")
@EnableTransactionManagement
public class H2JpaConfig {

/*	@Autowired
	private Environment env;

	@Bean
	
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("org.h2.Driver"));
		dataSource.setUrl(env.getProperty("jdbc:h2:mem:testdb"));
		dataSource.setUsername(env.getProperty("root"));
		dataSource.setPassword(env.getProperty("rootroot"));

		return dataSource;
	}
*/
} 
