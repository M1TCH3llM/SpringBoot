package com.synergisticit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.synergisticit.dao.EmployeeDao;
import com.synergisticit.domain.Employee;


public class EmployeeServiceImpl2 implements EmployeeService {
	
	// @Qualifier(value="employeeDao2")
	EmployeeDao employeeDao2;
	
	
	public void setEmployeeDao2(EmployeeDao employeeDao2) {
		this.employeeDao2 = employeeDao2;
	}

	@Override
	public Employee save(Employee e) {
		return employeeDao2.save(e);
	}

	@Override
	public Employee findById(int empId) {
		return employeeDao2.findById(empId);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao2.findAll();
	}

	@Override
	public Employee update(Employee e) {
		
		return employeeDao2.update(e);
	}

	@Override
	public void deleteById(int empId) {
		employeeDao2.deleteById(empId);

	}

}
