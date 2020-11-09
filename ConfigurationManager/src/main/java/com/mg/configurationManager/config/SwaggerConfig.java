package com.mg.configurationManager.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	private String AUTHORIZATION = "Authorization";
	private String HEADER = "header";
	private String BEARER = "Bearer access_token";
	
	@Bean
    public Docket headerAPI() {
        //Adding Header
        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder.name(AUTHORIZATION)                 
                         .modelRef(new ModelRef("string"))
                         .parameterType(HEADER)               
                         .defaultValue(BEARER)        
                         .required(false)         
                         .build();
        java.util.List<Parameter> aParameters = new ArrayList<>();
        aParameters.add(aParameterBuilder.build());             // add parameter
        return new Docket(DocumentationType.SWAGGER_2).select()
                                                      .apis(RequestHandlerSelectors
                                                              .any())
                                                      .paths(PathSelectors.any())
                                                      .build().
                                                              pathMapping("")
                                                      .globalOperationParameters(aParameters);
    }
}
