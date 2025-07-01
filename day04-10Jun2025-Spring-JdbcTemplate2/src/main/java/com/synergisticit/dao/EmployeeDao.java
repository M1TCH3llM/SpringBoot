package com.synergisticit.dao;

import java.util.List;

import com.synergisticit.domain.Employee;

public interface EmployeeDao {
	Employee save(Employee e);
    Employee findById(int empId);
    List<Employee> findAll();
    Employee update(Employee e);
    void deleteById(int empId);
}
