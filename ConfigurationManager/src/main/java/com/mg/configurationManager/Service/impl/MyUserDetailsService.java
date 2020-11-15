package com.mg.configurationManager.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.entity.User;
import com.mg.configurationManager.entityService.UserEntityService;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserEntityService UserService ; 
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User User = UserService.getUserByName(userName);
		if (User == null)
			throw new UsernameNotFoundException("User ["+userName+"] not found in records");
		else
			return User;
	}	
}