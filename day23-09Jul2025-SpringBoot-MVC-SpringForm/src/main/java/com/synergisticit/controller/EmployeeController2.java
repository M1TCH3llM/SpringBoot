package com.synergisticit.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.synergisticit.domain.Employee;
import com.synergisticit.domain.EmployeeType;
import com.synergisticit.domain.Gender;
import com.synergisticit.service.EmployeeService;
import com.synergisticit.validation.EmployeeValidator;

@Controller
public class EmployeeController2 {

    @Autowired EmployeeService employeeService;
    @Autowired EmployeeValidator employeeValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(employeeValidator);
    }

    @RequestMapping("employeeForm")
    public ModelAndView employeeForm(Employee e) {
        ModelAndView mav = new ModelAndView("employeeForm");
        populateModelAndView(mav);
        mav.addObject("e", e); // bind the form object if needed
        return mav;
    }

    @RequestMapping("saveEmployee")
    public ModelAndView saveEmployee(@Validated Employee e, BindingResult br) {
        ModelAndView mav = new ModelAndView("employeeForm");
        if (!br.hasErrors()) {
            Employee savedEmployee = employeeService.save(e);
            System.out.println("Employee saved: " + savedEmployee); // Consider replacing with logger
            return new ModelAndView("redirect:employeeForm");
        } else {
            populateModelAndView(mav);
            mav.addObject("hasErrors", true);
            return mav;
        }
    }

    @RequestMapping("deleteEmployee")
    public ModelAndView deleteEmployee(Employee e) {
        employeeService.deleteById(e.getEmpId());
        return new ModelAndView("redirect:employeeForm");
    }

    @RequestMapping("updateEmployee")
    public ModelAndView updateEmployee(Employee e) {
        ModelAndView mav = new ModelAndView("employeeForm");
        Employee existingEmp = employeeService.findById(e.getEmpId());
        mav.addObject("e", existingEmp);
        populateModelAndView(mav);
        return mav;
    }

    private void populateModelAndView(ModelAndView mav) {
        List<Employee> employees = employeeService.findAll();
        mav.addObject("employees", employees);
        mav.addObject("genders", Gender.values());
        mav.addObject("employeeType", EmployeeType.values());

        Set<String> skills = new HashSet<>();
        skills.add("Java");
        skills.add("Spring");
        skills.add("MySQL");
        skills.add("React");
        skills.add("Web Services");
        skills.add("Hibernate");
        mav.addObject("skills", skills);
    }
}
