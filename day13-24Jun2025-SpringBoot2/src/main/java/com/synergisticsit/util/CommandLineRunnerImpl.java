package com.synergisticsit.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
	
	@Autowired EmployeeService employeeService;


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Employee> employees = Arrays.asList(
			new Employee("Afraz", "CEO",  15556),
			new Employee("Jeremaih", "Pregrammer",  12987),
			new Employee("Tejas", "Sr. Pregrammer",  15556),
			new Employee("Himavan", "Tester",  15777),
			new Employee("Mike", "Pregrammer",  15556),
			new Employee("Mitch", "CTO",  20000)

);

//		employees.forEach(e -> employeeService.save(e));
		
		System.out.println("\nFinding all employees...");
		employeeService.findAll().forEach(System.out::println);
		
		System.out.println("\nFinding employee by id...");
		employeeService.findById(2);

	}

 
}
