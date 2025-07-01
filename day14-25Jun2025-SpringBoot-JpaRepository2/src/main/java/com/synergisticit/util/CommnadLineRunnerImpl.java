package com.synergisticit.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;

@Order(value=2)
@Component
public class CommnadLineRunnerImpl implements CommandLineRunner{
	
	@Autowired EmployeeService employeeService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(employeeService);
		List<Employee> employees = Arrays.asList(
//				new Employee("Afroz", "Programmer", 15556),
//				
//				new Employee("Himvan", "Sr. Programmer", 17556),
//				new Employee("Tejasvi", "Programmer", 15000),
//				new Employee("Oscar", "DBA", 17556),
//				new Employee("Mike Zeber", "Tester", 15000),
//		/		
				new Employee("Mitch", "Sr.Programmer", 20000)
				);
		
		 employees.forEach(e -> employeeService.save(e));
//		
		System.out.println("\nFinding all employees...");
		employeeService.findAll().forEach(System.out::println);
		
		System.out.println("\nFinding employee by id=2...");
		System.out.println(employeeService.findById(2));
		
		System.out.println("\nUpdating designation salary for employee with id=3...");
		System.out.println(employeeService.updateById(3, "Sr. Programmer", 17000));
		
		System.out.println("\nDeleting employee record with id=6...");
		employeeService.deleteById(6);
		
	}

}

