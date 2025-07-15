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
	
	@Autowired EmployeeService employeeServicel;
	
	
	@RequestMapping("employeeForm")
	public String employeeForm(Employee e, Model model) {
		List<Employee> employees = employeeServicel.findAll();
		
		model.addAttribute("employees", employees);
		System.out.println(e);
		return "employeeForm";
	}
	
	@RequestMapping("saveEmployee")
	public String saveEmployee(Employee e) {
		System.out.println("saveEmployee" + e);
		return "employeeForm";
		
	}

}
