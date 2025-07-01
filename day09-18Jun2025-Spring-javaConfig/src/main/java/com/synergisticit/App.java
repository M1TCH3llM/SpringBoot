package com.synergisticit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.synergisticit.config.AppConfig;
import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;

public class App {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("\nNumber of Beans Available: " + context.getBeanDefinitionCount());
        for (String bean : context.getBeanDefinitionNames()) {
            System.out.println(bean);
        }

        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService1");

        Employee e1 = new Employee(3, "Dinesh", "Instructor", 15600);
        // employeeService.save(e1);

        System.out.println("\nFind employee by ID...");
        employeeService.findById(1);

        System.out.println("\nFind all employees...");
        employeeService.findAll();

        System.out.println("\nUpdate employee...");
        e1 = new Employee(2, "Benjamin", "CEO", 75600);
        employeeService.update(e1);

        System.out.println("\nDelete employee by ID...");
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