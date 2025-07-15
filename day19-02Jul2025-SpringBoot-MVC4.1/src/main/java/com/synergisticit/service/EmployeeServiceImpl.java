package com.synergisticit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Employee;
import com.synergisticit.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int empId) {
		return employeeRepository.findById(empId).get();
	}

	@Override
	public Employee save(Employee e) {
		return employeeRepository.save(e);
	}

	@Override
	public void deleteById(int empId) {
		employeeRepository.deleteById(empId);
		
	}

	@Override
	public boolean existsById(int empId) {
		return employeeRepository.existsById(empId);
	}

}
