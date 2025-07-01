package com.synergisticit.service;

import java.util.List;

import com.synergisticit.dao.EmployeeDao;
import com.synergisticit.domain.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee save(Employee e) {
		return null;
	}

	@Override
	public Employee findById(int empId) {
		return null;
	}

	@Override
	public List<Employee> findAll() {
		return null;
	}

	@Override
	public Employee update(Employee e) {
		return null;
	}

	@Override
	public void deleteById(int empId) {

	}

}
