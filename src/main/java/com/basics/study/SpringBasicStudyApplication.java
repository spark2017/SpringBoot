package com.basics.study;

import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.basics.study.calculator.Calculator;
import com.basics.study.calculator.Operation;

@SpringBootApplication
public class SpringBasicStudyApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBasicStudyApplication.class, args);

		Calculator calculator = ctx.getBean(Calculator.class);
		calculator.calculate(137, 21, '+');
		//calculator.calculate(137, 21, '*');
		calculator.calculate(137, 21, '-');

	}

	@Bean
	public Calculator calculator(Collection<Operation> operations) {
		
		System.out.println("Bean method called.Size:" + operations.size());
		return new Calculator(operations);
	}

}
