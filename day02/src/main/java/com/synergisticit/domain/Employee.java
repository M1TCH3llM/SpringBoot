package com.synergisticit.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean{
	private int empId;
	private String name;
	private String designation;
	private int salary;
	private Address addr;
	public Address getAddress() {
		return addr;
	}




	
	
	
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
		this.addr = address;
	}
	

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + ", salary=" + salary
				+ ", address=" + addr + "]";
	}
	
	
	public void initMethod() {
		System.out.println("==========initMethod()=========");
	}
	
	public void destroyMethod() {
		System.out.println("=========destroyMethod()=========");
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("============afterPropertiesSet============");
	}


	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("============destroyMethod============");

	}


	public void setAddr(Address addr2) {
		// TODO Auto-generated method stub
		
	}
	
	
}
