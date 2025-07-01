package com.synergisticit.util;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;

//@Order(value=1)
@Order(value=3)
@Component
public class ABC implements CommandLineRunner{
	
	@Autowired EmployeeService employeeService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("=============ABC================");
		System.out.println("\nFindng employees with name Afroz:");
		List<Employee> employees = employeeService.findByName("Afroz");
		employees.forEach(e -> System.out.println(e));
		
		
		System.out.println("\nFindng employees by designation:");
		employees = employeeService.findByDesignation("Programmer");
		employees.forEach(e -> System.out.println(e));
		
		System.out.println("\nFindng employee by empId:");
		Employee employee = employeeService.findByEmpId(2);
		System.out.println(employee);
		
		System.out.println("\nFindng employees by salary:");
		employees = employeeService.findBySalary(15000);
		employees.forEach(e -> System.out.println(e.getName() +": "+e.getSalary()));
		
		System.out.println("\nFindng employees by getByName method:");
		employees = employeeService.getByName("Pooja");
		employees.forEach(e -> System.out.println(e));
		
		System.out.println("\nFindng employees by name method:");
		employees = employeeService.name("Afroz");
		employees.forEach(e -> System.out.println(e));
		
		System.out.println("\nFinding employees by name and salary:");
		employees = employeeService.findByNameAndSalary("Mike Zeber", 15000);
		employees.forEach(e -> System.out.println(e));
		
		System.out.println("\nFinding employees whose salary is less than 16K:");
		employees = employeeService.findEmployeeBySalLessThan16K();
		employees.forEach(e -> System.out.println(e));
		
		System.out.println("\nfindBySalaryLessThan(15500):");
		employees = employeeService.findBySalaryLessThan(15500);
		employees.forEach(e -> System.out.println(e));
		
		System.out.println("\nfindBySalaryGreaterThan(17000):");
		employees = employeeService.findBySalaryGreaterThan(17000);
		employees.forEach(e -> System.out.println(e));
		
		
		System.out.println("\nfindBySalaryGreaterThanOREqualTo(17000):");
		employees =  employeeService.findBySalaryGreaterThanOrEqualTo(17000);
		employees.forEach(e -> System.out.println(e));
		
		System.out.println("\nUsing native query:");
		employees =  employeeService.m1();
		employees.forEach(e -> System.out.println(e));
	}

}
