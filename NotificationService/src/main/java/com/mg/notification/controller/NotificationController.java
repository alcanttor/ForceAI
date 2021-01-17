package com.mg.notification.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mg.notification.model.EmailData;


@RestController
public class NotificationController {

	@PostMapping(value = "/Notify")
	public void getUserById(@RequestBody EmailData emailData)
	{
	//	return userService.createUser(user);
	}
	}
