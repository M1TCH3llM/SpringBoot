package com.synergisticit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;
import com.synergisticit.validation.EmployeeValidator;

@Controller
public class EmployeeController2 {
	
	
	@Autowired EmployeeService employeeService;
	@Autowired EmployeeValidator employeeValidator;
	
	@InitBinder 
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(employeeValidator);
	}
	
	@RequestMapping("employeeForm")
	public String employeeForm(Employee e, Model model) {
		List<Employee> employees = employeeService.findAll();
		
		model.addAttribute("employees", employees);
		System.out.println(e);
		return "employeeForm";
	}
	
	@RequestMapping("saveEmployee")
	public String saveEmployee(@Validated Employee e,  BindingResult br, Model model) {
		// employeeValidator.validate(e, br);
		
		System.out.println("****br.hasErrors(): "+br.hasErrors());
		if(!br.hasErrors()) {
			Employee savedEmployee = employeeService.save(e);
			System.out.println("savedEmployee: "+ savedEmployee);
			model.addAttribute("employees", employeeService.findAll());
			return "redirect:employeeForm";
		}else {
			model.addAttribute("employees", employeeService.findAll());
			return "employeeForm";
		}
	}
	
	//http://localhost:8080/deleteEmployee?empId=11
	@RequestMapping("deleteEmployee")
	public String deleteEmployee(Employee e, Model model) {
		employeeService.deleteById(e.getEmpId());
		model.addAttribute("employees", employeeService.findAll());
		return "employeeForm";
	}
	
	@RequestMapping("updateEmployee")
	public String updateEmployee(Employee e, Model model) {
		Employee rEmp = employeeService.findById(e.getEmpId());
		System.out.println("2. rEmp: "+rEmp);
		
		model.addAttribute("e", rEmp);
		model.addAttribute("employees", employeeService.findAll());
		return "employeeForm";
	}
	

}
