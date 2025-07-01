package com.synergisticit.service;

import java.util.List;

import com.synergisticit.dao.EmployeeDao;
import com.synergisticit.domain.Employee;

public class EmployeeServiceImpl2 implements EmployeeService {
	
	EmployeeDao employeeDao2;
	
	
	public void setEmployeeDao2(EmployeeDao employeeDao2) {
		this.employeeDao2 = employeeDao2;
	}

	@Override
	public Employee save(Employee e) {
		
		return null;
	}

	@Override
	public Employee findById(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee update(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int empId) {
		// TODO Auto-generated method stub

	}

}
