package com.synergisticit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;

public class App {
    public static void main(String[] args) {
    	
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	
     
    	System.out.println("\nNo of Beans Avaialble: "+context.getBeanDefinitionCount());
    	String[] beans = context.getBeanDefinitionNames();
    	for(String bean : beans) {
    		System.out.println(bean);
    	}
    	
    	EmployeeService  employeeService = (EmployeeService)context.getBean("employeeService");
    	
//    	Employee e1 = new Employee(1, "Oscar", "Programmer", 15000);
    	Employee e2 = new Employee(2, "Mike", "Programmer", 13000);
    	Employee e3 = new Employee(3, "Jan", "Programmer", 18000);
    	Employee e4 = new Employee(4, "Stew", "Programmer", 20000);
    	
    	System.out.println("App calling the employeeService...");
////    employeeService.save(e1);
//    	employeeService.save(e2);
//    	employeeService.save(e3);
//    	employeeService.save(e4);
    	
    	System.out.println("\nFinding employee by empId...");
    	Employee retrivedEmployee = employeeService.findById(1);
    	System.out.println("retrivedEmployee : "+ retrivedEmployee );
    	
    	System.out.println("\nFinding all employees...");
    	employeeService.findAll().forEach(System.out::println);
    	
    	System.out.println("\nUpdating the employee...");
    	Employee e1 = new Employee(2, "Mike", "Sr. Progmmer", 16999);
    	System.out.println(employeeService.update(e1));
    	
    	System.out.println("\nDeleting the employee...");
    	employeeService.deleteById(3);
    	
    	System.out.println("\nFinding all employees after deleting one...");
    	employeeService.findAll().forEach(System.out::println);
    	//context.close();
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