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
import com.synergisticit.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	
	 @Autowired EmployeeService employeeServicee;
	 
	 @RequestMapping("findAllEmpoloyees")
	 public ResponseEntity<List<Employee>> findAllEmployees() {
		List<Employee> employee = employeeService.findAll();
		 return ResponseEntity<List<Employee>>(HttpStatus.FOUND);
	 }
	 
	 @RequestMapping("findById")
	 public ResponseEntity<Employee> findById(@RequestParam int empId) {
		 Employee employee = employeeService.findById(empId);
		 return new ResponseEntity<Employee> (employee, HttpStatus.FOUND);
	 }
}
