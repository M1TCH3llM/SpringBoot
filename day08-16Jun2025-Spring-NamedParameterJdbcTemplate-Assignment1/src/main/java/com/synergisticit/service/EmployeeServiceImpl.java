package com.synergisticit.service;

import java.util.List;

import com.synergisticit.dao.EmployeeDao;
import com.synergisticit.domain.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
		System.out.println("employeeDao: "+employeeDao);
	}

	@Override
	public Employee save(Employee e) {
		System.out.println("EmployeeServiceImpl calling the employeeDao...");
		return employeeDao.save(e);
	}

	@Override
	public Employee findById(int empId) {
		return employeeDao.findById(empId);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Employee update(Employee e) {
		return employeeDao.update(e);
	}

	@Override
	public void deleteById(int empId) {
		employeeDao.deleteById(empId);         
	}

}