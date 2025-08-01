package com.synergisticit.service;

import java.util.List;


import com.synergisticit.domain.Employee;

public interface EmployeeService {
	
	Employee save(Employee e);
	Employee findById(int empId);
	List<Employee> findAll();
	Employee updateById(int empId, String designation, int salary);
	void deleteById(int empId);
	
	//================25-Jun-2025================
	List<Employee> findByName(String name);
	List<Employee> findByDesignation(String designation);
	Employee findByEmpId(int empId);
	List<Employee> findBySalary(int salary);
	List<Employee> getByName(String name);
	List<Employee> name(String name);
	List<Employee> findByNameAndSalary(String name, int salary);
	List<Employee> findEmployeeBySalLessThan16K();
	List<Employee> findBySalaryLessThan(int sal);
	List<Employee> findBySalaryGreaterThan(int sal);
	
	List<Employee> findBySalaryGreaterThanOrEqualTo(int sal);
	List<Employee> m1();
	   
}
