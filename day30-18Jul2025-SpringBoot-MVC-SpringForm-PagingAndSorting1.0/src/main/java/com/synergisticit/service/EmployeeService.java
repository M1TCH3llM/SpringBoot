package com.synergisticit.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.synergisticit.domain.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	Employee findById(int empId);
	Employee save(Employee e);
	void deleteById(int empId);
	Employee update(Employee e);
	
	boolean existsById(int empId);
	
	Page<Employee> findAll(Pageable pageable);


}
