package com.mg.configurationManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mg.configurationManager.Service.impl.JwtService;
import com.mg.configurationManager.Service.impl.UserService;
import com.mg.configurationManager.entity.User;
import com.mg.configurationManager.model.AuthorizationTokenResponse;
import com.mg.configurationManager.model.UserDto;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@GetMapping(value = "/User/{id}")
	public UserDto getUserById(@PathVariable Integer id)
	{
		return userService.getUserById(id);
	}
	
	@PostMapping(value = "/User")
	public UserDto getUserById(@RequestBody UserDto user)
	{
		return userService.createUser(user);
	}
	
	@PostMapping(value = "/UserUpdate")
	public UserDto updarteUserById(@RequestBody UserDto user)
	{
		return userService.updateUser(user,false);
	}
	
	@PostMapping(value = "/UserMege")
	public UserDto mergeUserById(@RequestBody UserDto user)
	{
		return userService.updateUser(user,true);
	}
	
	@DeleteMapping(value = "/User/{id}")
	public UserDto deleteUserById(@PathVariable Integer id)
	{
		userService.deleteUser(id);
		return null;
	}
	
	@GetMapping(value = "/token/{user}/{pass}")
	public AuthorizationTokenResponse getJwtToken(@PathVariable String user, @PathVariable String pass) throws Exception {
		try {
			System.out.println("username ["+user+"] password ["+pass+"]");
			//Authenticate the credentials based on user provided username and password
			authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(user, pass));
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		User userDetails = (User) userDetailsService.loadUserByUsername(user);
		String jwt = jwtService.generateToken(userDetails);
		AuthorizationTokenResponse response = new AuthorizationTokenResponse();
		response.setJwt(jwt);
		response.setUserId(userDetails.getId());
		return response;
	}
}
