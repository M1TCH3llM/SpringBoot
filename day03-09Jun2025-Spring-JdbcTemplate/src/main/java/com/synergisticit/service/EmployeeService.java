package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Employee;

public interface EmployeeService {
    Employee save(Employee e);
    Employee findById(int empId);
    List<Employee> findAll();
    Employee update(Employee e);
    void deleteById(int empId);
}
