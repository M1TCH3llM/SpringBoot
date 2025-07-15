package com.synergisticit.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
//@Table(name="Employee26Jun")

public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	
	@NotEmpty //(message="*Name should not be empty.")
	private String name;
	
	@NotEmpty// (message="*Designation should not be empty.")
	private String designation;
	
	//@Min(value = 15000, message = "*Salary must not be less than 15000.")
	//@Max(value = 85000, message = "*Salary must not greater than 85000.")
	@Min(value = 14999)
	@Max(value = 85000)
	private double salary;
	
	public Employee(){
		
	}

	public Employee(String name, String designation, Double salary) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	
	public Employee(Integer empId, String name, String designation, Double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + ", salary=" + salary
				+ "]";
	}
	
	
}
