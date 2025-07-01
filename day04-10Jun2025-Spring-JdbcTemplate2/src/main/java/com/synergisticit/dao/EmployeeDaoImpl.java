package com.synergisticit.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.synergisticit.domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Employee save(Employee e) {
		System.out.println("EmployeeDao calling the jdbcTemplate...");
		String sql = "insert into employee(empId, name, designation, salary) values(?, ?, ?, ?);";
	    int recordsInserted = 	jdbcTemplate.update(sql, new Object[] {e.getEmpId(), e.getName(), e.getDesignation(), e.getSalary() });
		System.out.println(recordsInserted+" employee  created.");
		return e;
	}

	@Override
	public Employee findById(int empId) {
		String sql = "select * from employee where empId=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {empId}, new BeanPropertyRowMapper<Employee>(Employee.class));
		
	}

	@Override
	public List<Employee> findAll() {
		String sql = "select * from employee";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
		 
	}

	@Override
	public Employee update(Employee e) {
		String sql = "update employee set salary=?, designation=? where empId=?"; 
		jdbcTemplate.update(sql, new Object[] {e.getSalary(), e.getDesignation(), e.getEmpId()});
		return e;
	}

	@Override
	public void deleteById(int empId) {
		String sql = "delete from employee where empId=?";
		jdbcTemplate.update(sql, new Object[] {empId});
		System.out.println("deleted employee with id="+empId);

	}

}

