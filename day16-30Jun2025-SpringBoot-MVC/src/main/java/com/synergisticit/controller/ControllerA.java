package com.synergisticit.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerA {
	// DispatherServlet 
	//  org.springframework.web.servlet
	
		@RequestMapping("a1")
		public void a1() {
			System.out.println("a1()...... ");
		}
		
		@RequestMapping("a2")
		public void a2() {
			System.out.println("a2()...... ");
		}
}
