package com.basics.reactive;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldReactiveController {

	private final TaskExecutor taskExecutor;

	public HelloWorldReactiveController(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	@GetMapping
	public CompletableFuture<String> hello() {
		return CompletableFuture.supplyAsync(() -> {
			randomDelay();
			return "Hello World, from Spring Boot 3!";
		}, taskExecutor);
	}

	private void randomDelay() {
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
