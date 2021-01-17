package com.mg.configurationManager.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JwtValidatorService {

	@Autowired
    private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtService jwtService;
	
	public UserDetails validateToke(String token)
    {
    	String username = jwtService.extractUsername(token);
    	UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    	if ((username.equals(userDetails.getUsername()))) //&& !jwtService.isTokenExpired(token)))
    			return userDetails;
    	else
    		return null;
    }
}