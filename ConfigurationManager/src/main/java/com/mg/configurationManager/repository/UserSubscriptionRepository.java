package com.mg.configurationManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mg.configurationManager.entity.UserSubscription;

@Repository
public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Integer>{

	public UserSubscription findByuserId(Integer userId);
	
}
