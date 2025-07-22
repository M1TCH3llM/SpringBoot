package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synergisticit.domain.Role;
import com.synergisticit.service.RoleService;

import jakarta.validation.Valid;

@Controller
public class RoleController {
	
	@Autowired RoleService roleService;

	@RequestMapping("roleForm")
	public String roleForm(Role role, Model model) {
		System.out.println("roleForm..........");
		return "roleForm";
	}
	
	@RequestMapping("saveRole")
	public String savesTheRole(@Valid @ModelAttribute Role role, BindingResult br, Model model) {
		System.out.println("roleForm..........");
		if(br.hasErrors()) {
			return "roleForm";
		}else {
			roleService.saveRole(role);
			return "redirect:roleForm";
		}
	}

}
