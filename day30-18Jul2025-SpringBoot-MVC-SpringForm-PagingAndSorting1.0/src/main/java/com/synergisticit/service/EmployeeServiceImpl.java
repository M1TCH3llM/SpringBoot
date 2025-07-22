package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		Optional<Employee> optEmployee = employeeRepository.findById(empId);
		if(optEmployee.isPresent()) {
			return optEmployee.get();
		}
		return null;
	}

	@Override
	public Employee save(Employee e) {
		Employee saved = employeeRepository.save(e);
		return employeeRepository.save(saved);
	}

	@Override
	public void deleteById(int empId) {
		employeeRepository.deleteById(empId);
		
	}

	@Override
	public boolean existsById(int empId) {
		return employeeRepository.existsById(empId);
	}

	@Override
	public Employee update(Employee e) {
		return employeeRepository.save(e);
	}

	@Override
	public Page<Employee> findAll(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}

}
