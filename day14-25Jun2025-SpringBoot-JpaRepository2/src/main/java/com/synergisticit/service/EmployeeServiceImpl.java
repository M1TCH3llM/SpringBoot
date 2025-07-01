package com.synergisticit.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.synergisticit.domain.Employee;
import com.synergisticit.repository.EmployeeRepository;

@Component
public class EmployeeServiceImpl implements EmployeeService{
	//CRUD => Create, Retrieve, Update, Delete
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee e) {
		Employee savedEmployee = employeeRepository.save(e);
		System.out.println("Saved employee with id: "+savedEmployee.getEmpId());
		return savedEmployee;
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
		/*
		List<Employee> list = new ArrayList<>();
		employeeRepository.findAll().forEach((e)->list.add(e));
		return list;
		*/
		return employeeRepository.findAll(Sort.by("name"));
		
	}

	@Override
	public void deleteById(int empId) {
		employeeRepository.deleteById(empId);
		System.out.println("Deleted employee record with id="+empId);
	}

	@Override
	public Employee updateById(int empId, String designation, int salary) {
		Employee foundEmployee = employeeRepository.findById(empId).get();
		foundEmployee.setDesignation(designation);
		foundEmployee.setSalary(salary);
		
		Employee updatedEmployee = employeeRepository.save(foundEmployee);
		return updatedEmployee;
	}

	@Override
	public List<Employee> findByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public List<Employee> findByDesignation(String designation) {
		return employeeRepository.findByDesignation(designation);
	}

	@Override
	public Employee findByEmpId(int empId) {
		return employeeRepository.findByEmpId(empId);
	}

	@Override
	public List<Employee> findBySalary(int salary) {
		return employeeRepository.findBySalary(salary);
	}

	@Override
	public List<Employee> getByName(String name) {
		return employeeRepository.getByName(name);
	}

	@Override
	public List<Employee> name(String name) {
		return employeeRepository.name(name);
	}

	@Override
	public List<Employee> findByNameAndSalary(String name, int salary) {
		return employeeRepository.findByNameAndSalary(name, salary);
	}

	@Override
	public List<Employee> findEmployeeBySalLessThan16K() {
		return employeeRepository.findEmployeeBySalLessThan16K();
	}

	@Override
	public List<Employee> findBySalaryLessThan(int sal) {
		return employeeRepository.findBySalaryLessThan(sal);
	}

	@Override
	public List<Employee> findBySalaryGreaterThan(int sal) {
		return employeeRepository.findBySalaryGreaterThan(sal);
	}

	@Override
	public List<Employee> findBySalaryGreaterThanOrEqualTo(int sal) {
		return employeeRepository.findBySalaryGreaterThanOrEqualTo(sal);
	}

	@Override
	public List<Employee> m1() {
		return employeeRepository.m1();
	}

	

	

	

}

