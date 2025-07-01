package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Employee;

public interface EmployeeService {
	
	//CRUD: create, read, update, delete
   
	Employee save(Employee e); //create
    Employee findById(int empId); //read
    List<Employee> findAll(); //read
    Employee update(Employee e); //update
    void deleteById(int empId);//delete
}
