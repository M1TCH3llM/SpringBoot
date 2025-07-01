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

import com.synergisticit.domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	NamedParameterJdbcTemplate npjdbcTemplate;
	
	@Override
	public Employee save(Employee e) {
		System.out.println("npjdbcTemplate");
		System.out.println("EmployeeDao calling the jdbcTemplate...");
		String sql = "insert into employee(empId, name, designation, salary) values(:empId, :name, :desig, :salary);";
	    
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("empId",  e.getEmpId());
		paramSource.addValue("name",  e.getName());
		paramSource.addValue("desig",  e.getDesignation());
		paramSource.addValue("salary",  e.getSalary());

		int recordsInserted = 	 npjdbcTemplate.update(sql, paramSource);
		System.out.println(recordsInserted+" employee  created.");
		return e;
	}

	public NamedParameterJdbcTemplate getNpjdbcTemplate() {
		return npjdbcTemplate;
	}

	public void setNpjdbcTemplate(NamedParameterJdbcTemplate npjdbcTemplate) {
		this.npjdbcTemplate = npjdbcTemplate;
	}

	@Override
	public Employee findById(int empId) {
		String sql = "select * from employee where empId=:empId";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("empId", empId);
		
		return npjdbcTemplate.queryForObject(sql, paramMap, new EmployeeRowMapper());
	}

	@Override
	public List<Employee> findAll() {
		String sql = "select * from employee";
		return npjdbcTemplate.query(sql, new EmployeeRowMapper());
		//return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public Employee update(Employee e) {
		String sql = "update employee set salary=:sal, designation=:design where empId=:empId"; 
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("sal", e.getSalary());
		paramMap.put("design", e.getDesignation());
		paramMap.put("empId", e.getEmpId());
		int recordsUpdated = npjdbcTemplate.update(sql, paramMap);
		if(recordsUpdated == 1) {
			System.out.println("Record Updated for empId="+e.getEmpId());
		}
		return e;
	}

	@Override
	public void deleteById(int empId) {
		String sql = "delete from employee where empId=:empId";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("empId", empId);
		
		int recordsDeleted = npjdbcTemplate.update(sql, paramMap);
		if(recordsDeleted == 1) {
			System.out.println("Record Deleted for empId=" + empId);
		}
//		System.out.println("deleted employee with id="+empId);

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

