package com.synergisticit.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.synergisticit.domain.Employee;


@Configuration
public class AppConfig {
	
  
	SessionFactory sessionFactory;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource  = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/springdbJun2025");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("Rb26Dett");
		
		return dataSource;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		
		return jdbcTemplate;
	}
	
	@Bean
	NamedParameterJdbcTemplate namedParameterJdbcTemplate () {
		NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(dataSource());
				return npjt;
	}
	
	
	@Bean
	LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.synergisticit");
		sessionFactory.setAnnotatedPackages("com.synergisticit.domain");
		sessionFactory.setAnnotatedClasses(Employee.class);
		sessionFactory.setHibernateProperties(properties());
		return sessionFactory;
	}
	
	
	//entityManagerFactory
	@Primary
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
		Properties hibernatProperties = new Properties();
		hibernatProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernatProperties.setProperty("hibernate.show_SQL", "true");
		hibernatProperties.setProperty("hibernate.hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return hibernatProperties;
	}

}
