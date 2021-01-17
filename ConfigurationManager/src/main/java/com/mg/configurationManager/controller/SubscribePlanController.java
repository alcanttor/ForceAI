package com.mg.configurationManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mg.configurationManager.Service.SubscriptionService;
import com.mg.configurationManager.model.SubscriptionPlanData;
import com.mg.configurationManager.model.UserSubscriptionDto;

@RestController
public class SubscribePlanController {

	@Autowired
	private SubscriptionService subscriptionService;
	
	@PostMapping("/SubscribeToPlan/{userId}")
	public UserSubscriptionDto subscribeToPlan(@PathVariable Integer userId, @RequestBody SubscriptionPlanData subscriptionPlanData)
	{
		return subscriptionService.subscribeToPlan(userId, subscriptionPlanData);
		
	}
	
	@GetMapping("/consumeExecutionCount/{siteToken}")
	public void consumeExecutionCount(@PathVariable String siteToken)
	{
		subscriptionService.consumeruleExecutionBySiteToken(siteToken);
	}
	
	@GetMapping("/getUserSubscriptionData/{siteToken}")
	public UserSubscriptionDto getUserSubscriptionData(@PathVariable String siteToken)
	{
		return subscriptionService.getSubscriptionData(siteToken);
	}
}
