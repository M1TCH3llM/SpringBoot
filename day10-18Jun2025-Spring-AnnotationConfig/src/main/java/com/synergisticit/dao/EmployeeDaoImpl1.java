package com.synergisticit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.synergisticit.domain.Employee;


public class EmployeeDaoImpl1 implements EmployeeDao {

	NamedParameterJdbcTemplate npjdbcTemplate;

	
	public void setNpjdbcTemplate(NamedParameterJdbcTemplate npjdbcTemplate) {
		this.npjdbcTemplate = npjdbcTemplate;
	}

	@Override
	public Employee save(Employee e) {
		System.out.println("npjdbcTemplate: "+npjdbcTemplate);
		System.out.println("EmployeeDao calling the jdbcTemplate...");
		String sql = "insert into employee(empId, name, designation, salary) values(:empId, :name, :desig, :sal);";
	    
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("empId", e.getEmpId());
		paramSource.addValue("name", e.getName());
		paramSource.addValue("desig", e.getDesignation());
		paramSource.addValue("sal", e.getSalary());
		
		int recordsInserted = 	npjdbcTemplate.update(sql, paramSource);
		System.out.println(recordsInserted+" employee  created.");
		return e;
	}

	@Override
	public Employee findById(int empId) {
		String sql = "select * from employee where empId=:empId";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("empId", empId);
		
		return npjdbcTemplate.queryForObject(sql, paramMap, new EmployeeRowMapper());
		//return npjdbcTemplate.queryForObject(sql, paramMap, BeanPropertyRowMapper.newInstance(Employee.class));
		 
		
	}

	@Override
	public List<Employee> findAll() {
		String sql = "select * from employee";
		System.out.println("npjdbcTemplate: "+npjdbcTemplate);
		System.out.println("find All: "+sql);
		return npjdbcTemplate.query(sql, new EmployeeRowMapper());
		 
	}

	//Update is an Idempotent operation
	@Override
	public Employee update(Employee e) {
		String sql = "update employee set salary=:sal, designation=:desig where empId=:empId"; 
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("sal", e.getSalary());
		paramMap.put("desig", e.getDesignation());
		paramMap.put("empId", e.getEmpId());
		int recordsUpdated = npjdbcTemplate.update(sql, paramMap);
		if(recordsUpdated ==1) {
			System.out.println("Record updated for empId="+e.getEmpId());
		}
		return e;
	}

	@Override
	public void deleteById(int empId) {
		String sql = "delete from employee where empId=:empId";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("empId", empId);
		
		int recordsDeleted = npjdbcTemplate.update(sql, paramMap);
		if(recordsDeleted ==1) {
			System.out.println("Record updated for empId="+empId);
		}
		//System.out.println("deleted employee with id="+empId);

	}

}

class EmployeeRowMapper implements RowMapper<Employee>{
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		int empId = rs.getInt("empId");
		String name = rs.getString("name");
		String desig = rs.getString("designation");
		int sal = rs.getInt("salary");
		
		System.out.println(empId +", "+name+", "+desig+", "+sal);
		return new Employee(empId,name, desig, sal);
	}
}
