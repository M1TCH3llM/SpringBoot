package com.synergisticit.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.synergisticit.domain.Employee;
import com.synergisticit.domain.EmployeeType;
import com.synergisticit.domain.Gender;
import com.synergisticit.service.EmployeeService;
import com.synergisticit.validation.EmployeeValidator;

@Controller
public class EmployeeController {
	
	
	@Autowired EmployeeService employeeService;
	@Autowired EmployeeValidator employeeValidator;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(employeeValidator);
	}
	
	//ModelAndView
	@RequestMapping("employeeForm")
	public ModelAndView employeeForm(Employee e) {
		ModelAndView mav = getModelAndView();
		mav.setViewName("employeeForm");
		return mav;
	}
	
	@RequestMapping("saveEmployee")
	public ModelAndView saveEmployee(@Validated Employee e,  BindingResult br) {
		ModelAndView mav = getModelAndView();
		mav.setViewName("employeeForm");
		mav.addObject("hasErrors", br.hasErrors());
		
		if(!br.hasErrors()) {
			employeeService.save(e);
			System.out.println("saveEmployee()..Saved employee....");
			mav.clear();
			mav.setViewName("redirect:/employeeForm");
			return mav;
		}else {
		
			return mav;
		}
	}
	
	//http://localhost:8080/deleteEmployee?empId=11
	@RequestMapping("deleteEmployee/{id}")
	public ModelAndView deleteEmployee(Employee e, @PathVariable int id) {
		employeeService.deleteById(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/employeeForm");
		return mav;
	}
	
	@RequestMapping("updateEmployee/{id}")
	public ModelAndView updateEmployee(Employee e, @PathVariable int id) {
		ModelAndView mav = getModelAndView();
		mav.setViewName("employeeForm");
		Employee rEmp = employeeService.findById(id);
		System.out.println("2. rEmp: "+rEmp);
		
		mav.addObject("e", rEmp);
		List<String> rSpokenLanguage = rEmp.getSpokenLanguages();
		Set<String> rSkills = rEmp.getSkills();
		String[] rHobbies = rEmp.getHobbies();
		Gender rGender = rEmp.getGender();
		EmployeeType rET = rEmp.getEmployeeType();
		
		mav.addObject("rSpokenLanguage", rSpokenLanguage);
		mav.addObject("rSkills", rSkills);
		
		//mav.addObject("rGender", rGender);
		//mav.addObject("rET", rET);
		
		if(rHobbies != null) {
			mav.addObject("rHobbies", Arrays.asList(rHobbies));
		}
		
		if(rGender != null) {
			mav.addObject("rGender", rGender.toString());
		}
		if(rET != null) {
			mav.addObject("rEmployeeType", rET.toString());
			System.out.println("***rET.toString(): "+rET.toString());
			System.out.println("***values as String: "+Arrays.toString(rET.values()));
			
		}
		
		mav.addObject("isInsured", rEmp.isInsured());
		
		
		return mav;
	}
	
	
	private ModelAndView getModelAndView() {
		
		ModelAndView mav =  new ModelAndView();
		mav.addObject("employees", employeeService.findAll());
		mav.addObject("genders", Gender.values());
		mav.addObject("employeeType", EmployeeType.values());
		
		List<String> spokenLanguages = new ArrayList<>();
		spokenLanguages.add("English");
		spokenLanguages.add("French");
		spokenLanguages.add("Spanish");
		spokenLanguages.add("Hindi");
		spokenLanguages.add("Arabic");
		mav.addObject("spokenLanguages", spokenLanguages);
		
		Set<String> skills = new HashSet<>();
		skills.add("Java");
		skills.add("MySQL");
		skills.add("Spring");
		skills.add("Web Services");
		skills.add("Hibernate");
		mav.addObject("skills", skills);
		
		String[] hobbies = {"Swimming", "Cyling", "Yoga", "Gardening", "Driving", "Others"};
		mav.addObject("hobbies", hobbies);
		
		return mav;
	}

}
