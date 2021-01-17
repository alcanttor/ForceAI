package com.mg.door.model;

import org.springframework.stereotype.Component;

@Component
public class SubscriptionPlanData {

	private Integer planId;

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	
	
}
