package com.synergisticit.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synergisticit.domain.Employee;

@Component
public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee e = (Employee)target;
		
		if(e.getSalary()==null) {
			errors.rejectValue("salary", "salary.min", "***Salary is a required field!");

		} else {
		if(e.getSalary() < 15000.00) {
			errors.rejectValue("salary", "salary.min", "***Minimum salary should not be < 15K.");
		}
		
		if(e.getSalary() > 85000.00) {
			errors.rejectValue("salary", "salary.max", "***Maximum salary should not be > 85K.");
			}
		}
		
		if(e.getDob()==null) {
			errors.rejectValue("dob", "dob.no", "***Select date of birth.");
		}
		
		if(e.getGender()==null) {
			errors.rejectValue("gender", "gender.not.selected", "***Select gender.");
		}
		
		if(e.getEmployeeType()==null) {
			errors.rejectValue("employeeType", "employeeType.not.selected", "***Select employee type.");
		}
		
		if(e.getEmail().isBlank()) {
			errors.rejectValue("email", "email.blank", "***Please provide the email id.");
		}
		
		if(e.getMobile().isBlank()) {
			errors.rejectValue("mobile", "mobile.blank", "***Please provide the mobile number.");
		}
		
		if(e.getSpokenLanguages().isEmpty()) {
			errors.rejectValue("spokenLanguages", "spokenLanguages.blank", "***Please select the spokenLanguages.");
		}
		
		if(e.getSkills().isEmpty()) {
			errors.rejectValue("skills", "skills.blank", "***Please select the skills.");
		}
		
		if(e.getHobbies().length<1) {
			errors.rejectValue("hobbies", "hobbies.no", "***Please select your hobbies.");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "***The name field should not be left empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designation", "designation.empty", "***The designation field should not be left empty.");
	}

}
