package com.mg.configurationManager.config;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class BeanConfig {

	@Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	@Bean
	public Map<String, String> getMap()
	{
		return new HashMap<String, String>();
	}
}
