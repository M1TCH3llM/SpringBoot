package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String userForm(User user, Model model) {
		//System.out.println("user: "+user);
		model.addAttribute("users", userService.findAll());
		model.addAttribute("roles", roleService.findAll());
		return "userForm";
	}
	
	@RequestMapping("saveUser")
	public String saveUserForm(@Validated @ModelAttribute User user, BindingResult br, Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("roles", roleService.findAll());
		
		if(br.hasErrors()) {
			model.addAttribute("hasErrors", br.hasErrors());
			return "userForm";
		}else {
			userService.save(user);
			return "redirect:userForm";
		}
	}
	
	
	@RequestMapping("update")
	public String updateUser(User user, Model model	) {
		user = userService.findById(user.getUserId());
		model.addAttribute("user", user);
		model.addAttribute("retrievedRole", user.getRoles());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("roles", roleService.findAll());
		return "userForm";
		
	}
	
	@RequestMapping("delete")
	public String deleteUser(User user, Model model	) {
		//user = userService.findById(user.getUserId());
		userService.deleteById(user.getUserId());
		model.addAttribute("user", user);
		
		return "redirect:userForm";
		
	}

}
