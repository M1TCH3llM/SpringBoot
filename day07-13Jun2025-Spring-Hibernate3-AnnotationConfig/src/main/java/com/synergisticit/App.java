package com.synergisticit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;

@Configuration
public class App {
    public static void main(String[] args) {
    	
    	
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//    	AbstractApplicationContext context = new AnnotationConfigApplicationContext();
     
    	System.out.println("\nNo of Beans Avaialble: "+context.getBeanDefinitionCount());
    	String[] beans = context.getBeanDefinitionNames();
    	for(String bean : beans) {
    		System.out.println(bean);
    	}
    	
    	EmployeeService employeeService = (EmployeeService)context.getBean("employeeService2");
    	
    	Employee e1 = new Employee(1, "Benjerman", "Progmmer", 15600);
    	employeeService.save(e1);
    	
    	System.out.println("\nFind employee by Id: ");
    	employeeService.findById(0);
    	
    	context.close();
    }
    
}

/*
create table springdbJun2025.Employee(
	empId int not null,
	name varchar(100) not null,
	designation varchar(100) not null,
	salary int not null,
	primary key(empId)		
);
*/