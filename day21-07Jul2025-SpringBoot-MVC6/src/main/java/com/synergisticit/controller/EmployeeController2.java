package com.synergisticit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;

@Controller
public class EmployeeController2 {
	
	@Autowired EmployeeService employeeService;
	
	@RequestMapping("employeeForm")
	public String employeeForm(Employee e, Model model) {
		List<Employee> employees = employeeService.findAll();
		
		model.addAttribute("employees", employees);
		System.out.println(e);
		return "employeeForm";
	}
	
	@RequestMapping("saveEmployee")
	public String saveEmployee(Employee e, Model model) {
		
		Employee employeeFromDB = employeeService.findById(e.getEmpId());
		System.out.println("****employeeFromDB: "+employeeFromDB);
		if(employeeFromDB != null) {
			employeeService.save(employeeFromDB);
		}else {
			Employee x = new Employee(e.getName(), e.getDesignation(), e.getSalary());
			employeeService.save(x);
			
		}
		
		//Employee saveEmployee = employeeService.save(e); -- cause of Problem
		//System.out.println("saveEmployee: "+ saveEmployee);
		model.addAttribute("employees", employeeService.findAll());
		return "employeeForm";
	}
	
	//http://localhost:8080/deleteEmployee?empId=11
	@RequestMapping("deleteEmployee")
	public String deleteEmployee(Employee e, Model model) {
		employeeService.deleteById(e.getEmpId());
		model.addAttribute("employees", employeeService.findAll());
		return "employeeForm";
	}
	
	@RequestMapping("updateEmployee")
	public String updateEmployee(Employee emp, Model model) {
		Employee rEmp = employeeService.findById(emp.getEmpId());
		
		
		model.addAttribute("e", rEmp);
		//employeeService.update(emp);
	

		model.addAttribute("employees", employeeService.findAll());
		return "employeeForm";
	}
	

}
