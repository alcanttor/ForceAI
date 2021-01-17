package com.mg.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

	@Bean
	RestTemplate getTemplate()
	{
		return new RestTemplate();
	}
}
