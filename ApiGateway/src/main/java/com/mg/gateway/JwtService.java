package com.mg.gateway;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="config-service")
@RibbonClient(name="config-service")
public interface JwtService {

	@PostMapping("/validateJwt")
	public User validateToken(@RequestBody String token) ;
	
	@GetMapping("/UserByName/{userName}")
	UserDto getUserByUsername(@PathVariable String userName);
	
}