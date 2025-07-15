package com.synergisticit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; 

@Controller
public class ControllerB {
	// org.springframework.web.servlet.DispatcherServlet

	@RequestMapping("b1")
	public void a1() {
		System.out.println("@RequestMapping(\"b1\" .....");
	}
	
	@RequestMapping("b2")
	public void a2() {
		System.out.println("@RequestMapping(\"b2\") .....");
	}

}
