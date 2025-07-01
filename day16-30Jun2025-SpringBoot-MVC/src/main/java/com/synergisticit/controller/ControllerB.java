package com.synergisticit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerB {
	// DispatherServlet 
	//  org.springframework.web.servlet
	
	@RequestMapping("b1")
	public ResponseEntity<String> b1() {
	    String str = "Abraham\nBenjamin\nChris\nDavid\nEric";
	    System.out.println(str);
	    return new ResponseEntity<>(str, HttpStatus.ACCEPTED);
	}
		
		@RequestMapping("b2")
		public void b2() {
			System.out.println("@RequestMappin (\"c2\"...... ");
		}
}
