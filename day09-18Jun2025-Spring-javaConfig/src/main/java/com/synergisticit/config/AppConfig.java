package com.synergisticit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.synergisticit.dao.EmployeeDao;
import com.synergisticit.dao.EmployeeDaoImpl;
import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;
import com.synergisticit.service.EmployeeServiceImpl;

@Configuration
public class AppConfig {

    @Autowired
    private DataSource dataSource;
    
	@Bean
public DriverManagerDataSource dataSource() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setUrl("jdbc:mysql://localhost:3306/springdbJun2025");
	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	dataSource.setUsername("root");
	dataSource.setPassword("Rb26Dett");
			return dataSource;
			}

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public EmployeeDao employeeDao() {
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        dao.setNpjdbcTemplate(namedParameterJdbcTemplate());
        return dao;
    }

    @Bean(name = "employeeService2") // match bean name used in App.java
    public EmployeeService employeeService() {
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        service.setEmployeeDao(employeeDao());
        return service;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.synergisticit.domain");
        sessionFactory.setAnnotatedClasses(Employee.class);

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }
}












