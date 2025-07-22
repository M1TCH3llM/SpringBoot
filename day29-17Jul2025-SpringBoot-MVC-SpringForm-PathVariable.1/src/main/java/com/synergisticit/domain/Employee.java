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

@NoArgsConstructor
@AllArgsConstructor

//Required arguments are final fields and fields with constraints such as @NonNull. 
@RequiredArgsConstructor 
@Getter
@Setter
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
	
	@Valid
	@Embedded
	private Address address;
	
	
	
	
	
}
