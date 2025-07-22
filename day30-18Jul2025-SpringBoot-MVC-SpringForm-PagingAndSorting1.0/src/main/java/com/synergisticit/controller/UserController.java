package com.synergisticit.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synergisticit.domain.Role;
import com.synergisticit.domain.User;
import com.synergisticit.service.RoleService;
import com.synergisticit.service.UserService;
import com.synergisticit.validation.UserValidator;

@Controller
public class UserController {
	
	@Autowired UserService userService;
	@Autowired RoleService roleService;
	@Autowired UserValidator userValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}
	
	@RequestMapping("userForm")
	public String userForm() {
		return "userForm";
	}
	
	@RequestMapping("saveUser")
	public String saveUserForm(@Validated @ModelAttribute User user, BindingResult br) {
		
		if(br.hasErrors()) {
			//model.addAttribute("hasErrors", br.hasErrors());
			return "userForm";
		}else {
			userService.save(user);
			return "redirect:/userForm";
		}
	}
	
	//http://localhost:8081/dinesh/update/11
	@RequestMapping("update/{id}")
	public String updateUser(@PathVariable int id,  Model model	) {
		Comparator<Role> comparator = (r1, r2) ->r1.getRolename().compareTo(r2.getRolename());
		User rUser = userService.findById(id);
		model.addAttribute("user", rUser);
		
		List<Role> rRoles = rUser.getRoles();
		Collections.sort(rRoles, comparator);
		model.addAttribute("retrievedRole", rRoles);
		
		return "userForm";
		
	}
	
	@RequestMapping("delete/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.deleteById(id);
		return "redirect:/userForm";
		
	}
	
	@ModelAttribute
	public void data(User user, Model model) {
		System.out.println("***data(User user, Model model)...");
		Comparator<Role> comparator = (r1, r2) ->r1.getRolename().compareTo(r2.getRolename());
		model.addAttribute("users", userService.findAll());
		
		List<Role> roles = roleService.findAll();
		Collections.sort(roles, comparator);
		model.addAttribute("roles", roles);
	}

}
