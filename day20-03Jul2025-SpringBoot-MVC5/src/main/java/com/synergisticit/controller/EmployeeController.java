package com.synergisticit.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired EmployeeService employeeService;
	
	//http://localhost:8080/findAllEmployees
	//http://localhost:8080/findAll
	//http://localhost:8080/xyz
	
	//@RequestMapping("findAllEmployees")
	@RequestMapping(value={"findAllEmployees", "findAll", "xyz"})
	public ResponseEntity<List<Employee>> findAllEmployees(){
		List<Employee> employees = employeeService.findAll();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.FOUND);
	}

	//http://localhost:8080/findById?empId=42
	@RequestMapping("findById")
	public ResponseEntity<Employee> findById(@RequestParam int empId){
		Employee employee = employeeService.findById(empId);
		return new ResponseEntity<Employee>(employee, HttpStatus.FOUND);
	}
	
	//http://localhost:8080/deleteById?empId=10
	@RequestMapping("deleteById")
	public ResponseEntity<String> deleteById(@RequestParam int empId){
		if(employeeService.existsById(empId)) {
			employeeService.deleteById(empId);
			return new ResponseEntity<String>("Employee record deleted for id="+empId, HttpStatus.FOUND);
		}else {
			return new ResponseEntity<String>("No employee with id="+empId, HttpStatus.NOT_FOUND);
		}	
	}
	
	
	//http://localhost:8080/save?name=Chi&designation=Tester&salary=16500
	@RequestMapping("save")
	public ResponseEntity<?> save( 
			@RequestParam String name, @RequestParam String designation,
			@RequestParam double salary
			){
		Employee e = new Employee(name, designation, salary);
		System.out.println("to save:"+e);
		Employee savedE = employeeService.save(e);
		if(savedE==null) {
			return new ResponseEntity<String>("Unable to save the employee object.", HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Employee>(savedE, HttpStatus.FOUND);
		}
		
	}
	
	
}
