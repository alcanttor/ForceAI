package com.mg.configurationManager.entityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.entity.UserSubscription;
import com.mg.configurationManager.repository.UserSubscriptionRepository;

@Service
public class UserSubscriptionEntityService {

	@Autowired
	private UserSubscriptionRepository userSubscriptionRepository;
	
	public UserSubscription addUserSubscription(UserSubscription userSubscription)
	{
		return userSubscriptionRepository.save(userSubscription);
	}
	
	public UserSubscription getUserSubscriptionByUserId(Integer userId)
	{
		return userSubscriptionRepository.findByuserId(userId);
	}
	
	public UserSubscription updateUserSubscription(UserSubscription userSubscription)
	{
		return userSubscriptionRepository.save(userSubscription);
	}
}
