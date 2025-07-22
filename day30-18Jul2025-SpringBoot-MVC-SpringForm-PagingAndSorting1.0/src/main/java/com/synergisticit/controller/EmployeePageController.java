package com.synergisticit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;

@Controller
public class EmployeePageController {
	@Autowired EmployeeService employeeService;
	
	// localhost:8081/oscar/findEmployeePages?pageNo=0&pageSize=5&sortedBy=name
	@RequestMapping("findEmployeePages")
	public ResponseEntity<List<Employee>> findAll(@RequestParam int pageNo,
			@RequestParam int pageSize, @RequestParam String sortedBy) {
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortedBy));
		Page<Employee> pagedEmployee = employeeService.findAll(pageable);
		List<Employee> employees = pagedEmployee.getContent();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.FOUND);
	}
	
	@RequestMapping("findEmployeePages2")
	public String findAll2(@RequestParam int pageNo,
			@RequestParam int pageSize, @RequestParam String sortedBy, Model model) {
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortedBy));
		Page<Employee> pagedEmployee = employeeService.findAll(pageable);
		List<Employee> employees = pagedEmployee.getContent();
		
		employees.forEach(e -> System.out.println());
		
		model.addAttribute("employees", employees);
		model.addAttribute("totalpages", pagedEmployee.getTotalPages());
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("sortedBy", sortedBy);


		
		return "pagedEmployee";
	}

	
}
