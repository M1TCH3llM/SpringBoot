package com.synergisticit.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
//@Table(name="Employee26Jun")

public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	
	@NonNull
	@NotEmpty //(message="*Name should not be empty.")
	private String name;
	
	@NonNull
	@NotEmpty //(message="*Designation should not be empty.")
	private String designation;
	
	@NonNull
	//@Min(value = 15000, message = "*Salary must not be less than 15000.")
	//@Max(value = 85000, message = "*Salary must not greater than 85000.")
	@Min(value = 14999)
	@Max(value = 85000)
	private Double salary;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)  // pattern can be used in place of iso
	private LocalDate dob;
	
	@Enumerated(EnumType.STRING) //by default EnumType.ORDINAL is used
	private Gender gender;
	
	@Enumerated(EnumType.STRING)
	private EmployeeType employeeType;
	
	@Email
	private String email;
	
	private String mobile;
	
	private boolean insured;
	
	@ElementCollection
	private List<String> spokenLanguages = new ArrayList<>();
	
	@ElementCollection
	private Set<String> skills = new HashSet<>();
	
	private String[] hobbies;
	
	@Embedded
	@Valid
	private Address address;
	
//
//	public Employee(String name, String designation, Double salary) {
//		super();
//		this.name = name;
//		this.designation = designation;
//		this.salary = salary;
//	}
//	
//	public Employee(Integer empId, String name, String designation, Double salary) {
//		super();
//		this.empId = empId;
//		this.name = name;
//		this.designation = designation;
//		this.salary = salary;
//	}
//
//	

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean isInsured() {
		return insured;
	}

	public void setInsured(boolean insured) {
		this.insured = insured;
	}

	public List<String> getSpokenLanguages() {
		return spokenLanguages;
	}

	public void setSpokenLanguages(List<String> spokenLanguages) {
		this.spokenLanguages = spokenLanguages;
	}

	public Set<String> getSkills() {
		return skills;
	}

	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + ", salary=" + salary
				+ "]";
	}
	
	
}
