package com.mg.configurationManager.Service.impl;

import java.sql.Timestamp;
import java.util.Calendar;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.Service.SubscriptionService;
import com.mg.configurationManager.entity.Plan;
import com.mg.configurationManager.entity.SubscriptionStatus;
import com.mg.configurationManager.entity.User;
import com.mg.configurationManager.entity.UserSubscription;
import com.mg.configurationManager.entityService.PlanEntityService;
import com.mg.configurationManager.entityService.UserEntityService;
import com.mg.configurationManager.entityService.UserSubscriptionEntityService;
import com.mg.configurationManager.model.SubscriptionPlanData;
import com.mg.configurationManager.model.SubscriptionResult;
import com.mg.configurationManager.model.UserSubscriptionDto;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

	@Autowired
	private UserSubscriptionEntityService userSubscriptionEntityService;
	@Autowired
	private UserEntityService userEntityService;
	@Autowired
	private PlanEntityService planEntityService; 
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserSubscriptionDto subscribeToPlan(Integer userId, SubscriptionPlanData subscriptionPlanData) {
		Plan plan = planEntityService.getPlanById(subscriptionPlanData.getPlanId());
		User user = userEntityService.getUserById(userId);
		if(plan.getPrice().doubleValue() != 0)
		{
			//call payment gateway
		}
		UserSubscription userSubscription = new UserSubscription();
		userSubscription.setPlan(plan);
		userSubscription.setUser(user);
		Calendar now = Calendar.getInstance();
		userSubscription.setStartDate(new Timestamp(now.getTimeInMillis()));
		now.add(Calendar.DATE, plan.getDuration());
		userSubscription.setEndDate(new Timestamp(now.getTimeInMillis()));
		userSubscription.setRuleCreationAllowed(plan.getRuleCreationAllowed());
		userSubscription.setRuleCreationAvailable(plan.getRuleCreationAllowed());
		userSubscription.setRuleCreationConsumed(0);
		userSubscription.setRuleExecutionAllowed(plan.getRuleExecutionAllowed());
		userSubscription.setRuleExecutionAvailable(plan.getRuleExecutionAllowed());
		userSubscription.setRuleExecutionConsumed(0);
		userSubscription.setSiteSharingAllowed(plan.getSiteSharingAllowed());
		userSubscription.setSiteSharingAvailable(plan.getSiteSharingAllowed());
		userSubscription.setSiteSharingConsumed(0);
		userSubscription.setSubscriptionStatus(SubscriptionStatus.ACTIVE);
		UserSubscription userSubscriptionSaved = userSubscriptionEntityService.addUserSubscription(userSubscription);
		UserSubscriptionDto userSubscriptionDto = new UserSubscriptionDto();
		modelMapper.map(userSubscriptionSaved,userSubscriptionDto);
		return userSubscriptionDto;
	}

	@Override
	public SubscriptionResult upgradePlan(Integer userId, SubscriptionPlanData subscriptionPlanData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserSubscriptionDto getSubscriptionDetailsByUserId(Integer userId) {
		UserSubscription userSubscription = userSubscriptionEntityService.getUserSubscriptionByUserId(userId);
		UserSubscriptionDto userSubscriptionDto = new UserSubscriptionDto();
		modelMapper.map(userSubscription,userSubscriptionDto);
		return userSubscriptionDto;
	}

	@Override
	public void consumeSiteSharing(Integer userId) {
		UserSubscription userSubscription = userSubscriptionEntityService.getUserSubscriptionByUserId(userId);
		int siteSharingAvailable = userSubscription.getSiteSharingAvailable();
		int siteSharingConsumed = userSubscription.getSiteSharingConsumed();
		siteSharingAvailable--;
		siteSharingConsumed++;
		userSubscription.setSiteSharingAvailable(siteSharingAvailable);
		userSubscription.setSiteSharingConsumed(siteSharingConsumed);
		userSubscriptionEntityService.updateUserSubscription(userSubscription);
	}

	@Override
	public void consumeruleCreation(Integer userId) {
		UserSubscription userSubscription = userSubscriptionEntityService.getUserSubscriptionByUserId(userId);
		int siteRuleCreationAvailable = userSubscription.getRuleCreationAvailable();
		int siteRuleCreationConsumed = userSubscription.getRuleCreationConsumed();
		siteRuleCreationAvailable--;
		siteRuleCreationConsumed++;
		userSubscription.setRuleCreationAvailable(siteRuleCreationAvailable);
		userSubscription.setRuleCreationConsumed(siteRuleCreationConsumed);
		userSubscriptionEntityService.updateUserSubscription(userSubscription);
		
	}

	@Override
	public void consumeruleExecution(Integer userId) {
		UserSubscription userSubscription = userSubscriptionEntityService.getUserSubscriptionByUserId(userId);
		int siteRuleExecutionAvailable = userSubscription.getRuleExecutionAvailable();
		int siteRuleExecutionConsumed = userSubscription.getRuleExecutionConsumed();
		siteRuleExecutionAvailable--;
		siteRuleExecutionConsumed++;
		userSubscription.setRuleExecutionAvailable(siteRuleExecutionAvailable);
		userSubscription.setSiteSharingConsumed(siteRuleExecutionConsumed);
		userSubscriptionEntityService.updateUserSubscription(userSubscription);
	}

}
