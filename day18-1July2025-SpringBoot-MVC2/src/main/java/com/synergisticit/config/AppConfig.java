package com.synergisticit.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@PropertySource(value="classpath:a.properties")
@Configuration
public class AppConfig {
	
	@Autowired Environment env;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource  = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("url"));
		dataSource.setDriverClassName(env.getProperty("driverClassName"));
		dataSource.setUsername(env.getProperty("un"));
		dataSource.setPassword(env.getProperty("p"));
		
		return dataSource;
	}
	
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.synergisticit.domain");
		
		emf.setJpaProperties(properties());
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return emf;
		
	}
	
	
	Properties properties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_SQL", "true");
		properties.setProperty("hibernate.hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return properties;
	}

}
