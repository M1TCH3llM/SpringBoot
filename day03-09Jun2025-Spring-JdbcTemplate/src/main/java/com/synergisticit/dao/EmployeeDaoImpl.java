package com.synergisticit.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.synergisticit.domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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
