package com.basics.webflux;

import org.junit.Test;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class HelloWorldControllerTest {
	
	private final HelloWorldController controller = new HelloWorldController();
	  @Test
	  public void shouldSayHello() {
	    Mono<String> result = controller.hello();
	    
	    // Need Maven dependency reactor-test
	    StepVerifier.create(result)
	            .expectNext("Hello World, from Reactive Spring Boot 2!")
	            .verifyComplete();
	  }

}
