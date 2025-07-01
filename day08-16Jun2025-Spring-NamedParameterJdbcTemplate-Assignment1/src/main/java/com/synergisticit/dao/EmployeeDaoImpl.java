package com.synergisticit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.synergisticit.domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	NamedParameterJdbcTemplate npjdbcTemplate;

	
	public Employee save(Employee e) {
		System.out.println("EmployeeDao calling the jdbcTemplate...");
		   String sql = "INSERT INTO employee (empId, name, designation, salary) " + "VALUES (:empId, :name, :designation, :salary)";		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("empId", e.getEmpId());
		paramSource.addValue("name", e.getName());
		paramSource.addValue("designation", e.getDesignation());
		paramSource.addValue("salary", e.getSalary());
		

	    int recordsInserted = npjdbcTemplate.update(sql, paramSource);
	    System.out.println(recordsInserted + " employee created.");
		return e;
		


	}
	
	public NamedParameterJdbcTemplate getNpjdbcTemplate() {
		return npjdbcTemplate;
	}
	
	public void setNpjdbcTemplate(NamedParameterJdbcTemplate npjdbcTemplate) {
		this.npjdbcTemplate = npjdbcTemplate;
	}

	public Employee findById(int empId) {
		String sql = "select * from employee where empId=:empId";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("empId", empId);
		
		return npjdbcTemplate.queryForObject(sql, paramMap, new EmployeeRowMapper());
		
	}
	
	public List<Employee> findAll(){
		String sql = "select * from Employee";
		return npjdbcTemplate.query(sql, new EmployeeRowMapper());
		
	}
	
	public Employee update(Employee e) {
		String sql = "update employee set salary=:sal, designation=:designation where empId=:empId";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("sal", e.getSalary());
		paramMap.put("designation", e.getDesignation()); 
		paramMap.put("empId", e.getEmpId());
		int recordsUpdated = npjdbcTemplate.update(sql, paramMap);
		if(recordsUpdated == 1) {
			System.out.println("Record Updated for empId="+e.getEmpId());
		}
		return e;
	}
	
	public void deleteById(int empId) {
		String sql = "delete from employee where empId=:empId";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("empId", empId);
		
		int recordsDeleted = npjdbcTemplate.update(sql, paramMap);
		if(recordsDeleted == 1) {
			System.out.println("Record Deleted for empId=" + empId);
		}
	}
	
	class EmployeeRowMapper implements RowMapper<Employee>{
		
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			int empId = rs.getInt("empId");
			String name =rs.getString("name");
			String desig =rs.getString("designation");
			int sal = rs.getInt("salary");
			return new Employee(empId, name, desig, sal);
		}
	}
	
	
	
}
