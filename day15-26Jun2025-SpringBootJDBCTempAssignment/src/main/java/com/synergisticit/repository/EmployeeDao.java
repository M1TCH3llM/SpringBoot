package com.synergisticit.repository;

import com.synergisticit.domain.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Employee> rowMapper = new RowMapper<>() {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee e = new Employee();
            e.setEmpId(rs.getInt("empId"));
            e.setName(rs.getString("name"));
            e.setDesignation(rs.getString("designation"));
            e.setSalary(rs.getDouble("salary"));
            return e;
        }
    };

    public Employee save(Employee e) {
        if (e.getEmpId() == null) {
            jdbcTemplate.update("INSERT INTO employee (name, designation, salary) VALUES (?, ?, ?)",
                e.getName(), e.getDesignation(), e.getSalary());
        } else {
            jdbcTemplate.update("UPDATE employee SET name=?, designation=?, salary=? WHERE empId=?",
                e.getName(), e.getDesignation(), e.getSalary(), e.getEmpId());
        }
        return e;
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employee", rowMapper);
    }

    public Optional<Employee> findById(int id) {
        List<Employee> result = jdbcTemplate.query("SELECT * FROM employee WHERE empId = ?", rowMapper, id);
        return result.stream().findFirst();
    }

    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM employee WHERE empId = ?", id);
    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM employee");
    }
}
