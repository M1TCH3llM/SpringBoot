package com.synergisticit.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.synergisticit.domain.Employee;
import com.synergisticit.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService{
	//CRUD => Create, Retrieve, Update, Delete
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee e) {
		
		return employeeRepository.save(e);
	}

	@Override
	public Employee findById(int empId) {
		Optional<Employee> optEmployee = employeeRepository.findById(empId);
		if(optEmployee.isPresent()) {
			return optEmployee.get();
		}
		return null;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> list=null;
		employeeRepository.findAll().forEach((e)->list.add(e));
		return list;
	}

	@Override
	public void deleteById(int empId) {
		employeeRepository.deleteById(empId);
	}

	

}
