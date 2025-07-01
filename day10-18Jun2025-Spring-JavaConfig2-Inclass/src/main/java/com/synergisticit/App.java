package com.synergisticit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.synergisticit.config.AppConfig;
import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;

//@Configuration
public class App {
    public static void main(String[] args) {
    	
    	
    	//AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
     
    	System.out.println("\nNo of Beans Avaialble: "+context.getBeanDefinitionCount());
    	String[] beans = context.getBeanDefinitionNames();
    	for(String bean : beans) {
    		System.out.println(bean);
    	}
    	
    	EmployeeService employeeService = (EmployeeService)context.getBean("employeeService1");
    	System.out.println("employeeService: "+employeeService);
    	Employee e1 = new Employee(13, "Dinesh", "Instructor", 15600);
    	// employeeService.save(e1);
    	
    	//System.out.println("\nFind employee by Id:... ");
    	//employeeService.findById(1);
    	
    	System.out.println("\nFind all:.... ");
    	employeeService.findAll().forEach(e-> System.out.println(e));
    	
    	System.out.println("\nUpdate:.... ");
    	//Employee [empId=2, name=Benjamin, designation=Progmmer, salary=15600]
    	e1 = new Employee(2, "Benjamin", "CEO", 75600);
    	employeeService.update(e1);
    	
    	
    	System.out.println("\nDelete:.... ");
    	employeeService.deleteById(4);
    	
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