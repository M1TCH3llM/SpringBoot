package com.synergisticit.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


//@Table
@Entity
public class Employee{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	
	//@Column
	private String name;
	
	private String designation;
	
	private int salary;
	
	
	public Employee() {
		
	}

	public Employee(int empId, String name, String designation, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	
	public Employee(String name, String designation, int salary) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + ", salary=" + salary
				+  "]";
	}
		

}
