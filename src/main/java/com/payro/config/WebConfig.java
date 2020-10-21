package com.payro.config;

import javax.sql.DataSource;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.payro.*")
@PropertySource("classpath:database.properties")
public class WebConfig {

	@Autowired
	Environment env;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(env.getProperty("url"));
		driverManagerDataSource.setUsername(env.getProperty("dbuser"));
		driverManagerDataSource.setPassword(env.getProperty("dbpassword"));
		driverManagerDataSource.setDriverClassName(env.getProperty("driver")); 
		return driverManagerDataSource;
		
		
	}
	
	
	
}
