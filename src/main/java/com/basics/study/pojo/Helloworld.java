package com.basics.study.pojo;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Helloworld {

	@PostConstruct
	public void displayHellow() {
		System.out.println("Hello..");
	}
	
}
