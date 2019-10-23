package com.basics.web.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	
	@GetMapping("/")
	public String display() {
		
		return "Hello Spring boot";
	}
	
}
