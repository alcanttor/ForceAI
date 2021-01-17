package com.mg.door;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.jms.annotation.EnableJms;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients
@EnableJms
//@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class Door {

	public static void main(String[] args) {
		SpringApplication.run(Door.class, args);
	}

} 
