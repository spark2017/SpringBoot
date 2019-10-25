package com.basics.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloWorldController {

	@GetMapping
	public Mono<String> hello() {
		return Mono.just("Hello World, from Spring Boot 2!");
	}

}
