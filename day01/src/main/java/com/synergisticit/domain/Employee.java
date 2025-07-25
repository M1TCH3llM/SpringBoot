package com.synergisticit.domain;

public class Employee {
	private int empId;
	private String name;
	private String designation;
	private int salary;
	
	public Address getAddress() {
		return address;
	}




	private Address address;
	
	
	public Employee() {
		
	}


	public Employee(int empId, String name, String designation, int salary) {
		super();
		this.empId = empId;
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
	

	public void setAddress(Address address) {
		this.address = address;
	}
	

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + ", salary=" + salary
				+ ", address=" + address + "]";
	}
	
	
	
	
	
}
