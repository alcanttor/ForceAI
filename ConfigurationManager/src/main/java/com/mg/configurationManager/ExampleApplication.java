package com.mg.configurationManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebSecurity
@EnableSwagger2
//@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

} 
