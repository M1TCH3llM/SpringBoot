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
		if(e.getSalary() < 15000) {
			errors.rejectValue("salary", "salary.min", "***Minimum salary should not be < 15K.");
		}
		
		if(e.getSalary() > 85000) {
			errors.rejectValue("salary", "salary.max", "***Maximum salary should not be > 85K.");
		}
		
		if(e.getEmployeeType() == null) {
			errors.rejectValue("employeeType", "employeeType.not.selected", "***Pleases select type ");
		}
		
		if(e.getEmail().isBlank()) {
			errors.rejectValue("email", "email.black", "***Pleases fill out emai");
		}
		
		
		if(e.getMobile().isBlank()) {
			errors.rejectValue("mobile", "mobile.black", "***Pleases fill out mobile");
		}
		
		if(e.getEmail().isBlank()) {
			errors.rejectValue("email", "email.black", "***Pleases fill out emai");
		}
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "***The name field should not be left empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designation", "designation.empty", "***The designation field should not be left empty.");
	}

}
