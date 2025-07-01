package com.synergisticit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("\nNo of Beans Available: " + context.getBeanDefinitionCount());
        String[] beans = context.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }

        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        // Add employees
        Employee e2 = new Employee(2, "Mike", "Programmer", 13000);
        Employee e3 = new Employee(3, "Jan", "Sr. Programmer", 18000);
        Employee e4 = new Employee(4, "Stew", "Programmer", 20000);

        System.out.println("App calling the employeeService...");
        // employeeService.save(new Employee(1, "Oscar", "Programmer", 15000));
        // employeeService.save(e2);
        employeeService.save(e3);
        employeeService.save(e4);

        // Find by ID
        System.out.println("\nFinding employee by empId...");
        Employee retrievedEmployee = employeeService.findById(3);
        System.out.println("retrievedEmployee: " + retrievedEmployee);

        // Find all
        System.out.println("\nFinding all employees...");
        employeeService.findAll().forEach(System.out::println);

        // Update
        System.out.println("\nUpdating the employee...");
        Employee updatedE2 = new Employee(2, "Mike", "Staff Programmer", 20000);
        System.out.println("Rows updated: " + employeeService.update(updatedE2));

        // Delete
        System.out.println("\nDeleting the employee with empId=3...");
        employeeService.deleteById(3);

        // Find all after delete
        System.out.println("\nFinding all employees after deleting one...");
        employeeService.findAll().forEach(System.out::println);

        // Optional: if using AbstractApplicationContext
        // ((ClassPathXmlApplicationContext) context).close();
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