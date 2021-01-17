package com.mg.door.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.door.Service.SiteRuleService;
import com.mg.door.Service.SiteService;
import com.mg.door.model.HoaderData;
import com.mg.door.model.SiteDto;
import com.mg.door.model.SiteRuleDto;

@Service
public class RuleEngine {

	@Autowired
	private ForceAIprocessor forceAIprocessor;
	@Autowired
	private SiteService siteService;
	
	public void processEvent(HoaderData hoaderData)
	{
		SiteDto siteDto =siteService.getSiteByToken(hoaderData.getSiteToken());
		System.out.println("Site id found ["+siteDto.getId()+"]");
		List<SiteRuleDto> siteRuleDto = siteService.getRules(siteDto.getId(),hoaderData.getEvent());
		System.out.println("Site rules for site ["+siteDto.getId()+"] size ["+siteRuleDto.size()+"]");
		for (SiteRuleDto siteRuleDto2 : siteRuleDto) {
			System.out.println("Siterule data........"+siteRuleDto2.getAvailableRuleDto().getDefaultEmailTemplateDto());
			System.out.println("Siterule data........"+siteRuleDto2.getAvailableRuleDto().getDefaultEmailTemplateDto().getId());
			System.out.println("Siterule data........"+siteRuleDto2.getAvailableRuleDto().getDefaultEmailTemplateDto().getBody());
			forceAIprocessor.processEventAndAct(siteRuleDto2,hoaderData);
		}
		
	}
}
