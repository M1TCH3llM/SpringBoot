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
	
	//@RequestMapping"findAllEmployees")
	@RequestMapping(value={"findAllEmployees", "findAll", "xyz"})
	public ResponseEntity<List<Employee>> findAllEmployees(){
		List<Employee> employees = employeeService.findAll();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.FOUND);
	}

	@RequestMapping("findById")
	public ResponseEntity<Employee> findById(@RequestParam int empId){
		Employee employee = employeeService.findById(empId);
		return new ResponseEntity<Employee>(employee, HttpStatus.FOUND);
	}
	
	@RequestMapping("deleteById")
	public ResponseEntity<String> deleteById(@RequestParam int empId){
		employeeService.deleteById(empId);
		return new ResponseEntity<String>("Employee record deleted from id =" + empId, HttpStatus.FOUND);
	}
	
	@RequestMapping("save")
	public ResponseEntity<Employee> save(@RequestParam int empId,
			@RequestParam String name, @RequestParam String designation,
			@RequestParam int salary){
		Employee e = new Employee(empId, name,designation, salary);
		Employee savedE= employeeService.save(e);
		if(savedE==null) {
			return new ResponseEntity<String>("Unable to save employee object", HttpStatus.FOUND);
		}
		return new ResponseEntity<Employee>(savedE, HttpStatus.FOUND);
	}
}
