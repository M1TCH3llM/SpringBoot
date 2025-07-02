package com.synergisticit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; 

@Controller
public class ControllerC {
	// org.springframework.web.servlet.DispatcherServlet

	@RequestMapping("c1")
	public ResponseEntity<String> c1() {
		String str1 = "Abraham\nBenjamin\nChris\nDavid\nEric";
		String str2 = "Abraham<br>Benjamin<br>Chris<br>David<br>Eric";
		System.out.println(str1);
		
		return new ResponseEntity<String>(str2, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("c2")
	public void c2() {
		System.out.println("@RequestMapping(\"b2\") .....");
	}

}
