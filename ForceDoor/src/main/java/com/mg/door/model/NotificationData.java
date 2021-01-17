package com.mg.door.model;

import org.springframework.stereotype.Component;

@Component
public class NotificationData {

	private SiteRuleDto siteRuleDto; 
	private HoaderData hoaderData;
	public SiteRuleDto getSiteRuleDto() {
		return siteRuleDto;
	}
	public void setSiteRuleDto(SiteRuleDto siteRuleDto) {
		this.siteRuleDto = siteRuleDto;
	}
	public HoaderData getHoaderData() {
		return hoaderData;
	}
	public void setHoaderData(HoaderData hoaderData) {
		this.hoaderData = hoaderData;
	}
	
	
}
