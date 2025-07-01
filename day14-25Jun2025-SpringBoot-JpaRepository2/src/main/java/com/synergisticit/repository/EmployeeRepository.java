package com.synergisticit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.synergisticit.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
// method name based on fields of the entity
   List<Employee> findByName(String name);
   List<Employee> findByDesignation(String designation);
   Employee findByEmpId(int empId);
   List<Employee> findBySalary(int salary);
   
   List<Employee> getByName(String name);
   List<Employee> name(String name);
   
   List<Employee> findByNameAndSalary(String name, int salary);
   
   @Query("from Employee e where e.salary<16000")
   List<Employee> findEmployeeBySalLessThan16K();
   
   List<Employee> findBySalaryLessThan(int sal);
  // List<Employee> findBySalaryLessThanOrEqualTo(int sal);
   
   List<Employee> findBySalaryGreaterThan(int sal);
   
   @Query("from Employee e where e.salary>= :sal")
   List<Employee> findBySalaryGreaterThanOrEqualTo(@Param("sal") int salary);
   
   
   //List<Employee> findEmployeesUsingNativeQuery();
   
   @Query(value="select * from employee", nativeQuery=true)
   List<Employee> m1();
   
   
   
   
}
