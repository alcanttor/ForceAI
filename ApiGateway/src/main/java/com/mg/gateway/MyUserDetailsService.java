package com.mg.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	JwtService userFetchService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("starting....................................");
		UserDto userDto =  userFetchService.getUserByUsername(username);
		
		User user = new User();
		user.setPassword(userDto.getPassword());
		user.setUsername(userDto.getUserName());
		System.out.println("got............"+user);
		return user;
	}

}
