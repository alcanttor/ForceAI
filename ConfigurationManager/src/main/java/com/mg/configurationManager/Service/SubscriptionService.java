package com.mg.configurationManager.Service;

import com.mg.configurationManager.model.SubscriptionPlanData;
import com.mg.configurationManager.model.SubscriptionResult;
import com.mg.configurationManager.model.UserSubscriptionDto;

public interface SubscriptionService {

	public UserSubscriptionDto subscribeToPlan(Integer userId, SubscriptionPlanData subscriptionPlanData);
	
	public SubscriptionResult upgradePlan(Integer userId, SubscriptionPlanData subscriptionPlanData);
	
	public UserSubscriptionDto getSubscriptionDetailsByUserId(Integer userId);

	public void consumeSiteSharing(Integer userId);
	
	public void consumeruleCreation(Integer userId);
	
	public void consumeruleExecution(Integer userId);
}
