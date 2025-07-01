package com.synergisticit.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.synergisticit.dao.EmployeeDao;
import com.synergisticit.dao.EmployeeDaoImpl1;
import com.synergisticit.dao.EmployeeDaoImpl2;
import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;
import com.synergisticit.service.EmployeeServiceImpl1;
import com.synergisticit.service.EmployeeServiceImpl2;

@ImportResource(value="classpath:beans.xml")
//@Configuration
public class AppConfig {
	
	@Autowired
	DataSource dataSource;
	
	
	@Bean
	public DriverManagerDataSource dataSource() {
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
		jdbcTemplate.setDataSource(dataSource);
		
		return jdbcTemplate;
	}
	
	@Bean
	NamedParameterJdbcTemplate namedParameterJdbcTemplate () {
		NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(dataSource)
				;
				return npjt;
	}
	
	@Bean(value="employeeDao1")
	EmployeeDao  employeeDao1() {
		EmployeeDaoImpl1 employeeDao1 = new EmployeeDaoImpl1();
		employeeDao1.setNpjdbcTemplate(namedParameterJdbcTemplate ());
		return employeeDao1;
	}
	
	@Bean(value="employeeDao2")
	EmployeeDao  employeeDao2() {
		EmployeeDaoImpl2 employeeDao2 = new EmployeeDaoImpl2();
		employeeDao2.setSessionFactory(null);
		return employeeDao2;
	}
	
	@Bean(value="employeeService1")
	EmployeeService employeeService1() {
		EmployeeServiceImpl1 employeeService = new EmployeeServiceImpl1();
		employeeService.setEmployeeDao(employeeDao1());
		return employeeService;
	}
	
	@Bean(value="employeeService2")
	EmployeeService employeeService2() {
		EmployeeServiceImpl2 employeeService2 = new EmployeeServiceImpl2();
		employeeService2.setEmployeeDao2(employeeDao2());
		return employeeService2;
	}
	
	
	@Bean
	LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.synergisticit");
		sessionFactory.setAnnotatedPackages("com.synergisticit.domain");
		sessionFactory.setAnnotatedClasses(Employee.class);
		
		Properties hibernatProperties = new Properties();
		hibernatProperties.setProperty("hibernate.hbm2.ddl.auto", "update");
		hibernatProperties.setProperty("hibernate.show_SQL", "true");
		hibernatProperties.setProperty("hibernate.hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		sessionFactory.setHibernateProperties(hibernatProperties);
		return sessionFactory;
	}

}
