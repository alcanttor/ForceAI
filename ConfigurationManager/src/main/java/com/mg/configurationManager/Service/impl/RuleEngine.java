package com.mg.configurationManager.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.Service.SiteRuleService;
import com.mg.configurationManager.Service.SiteService;
import com.mg.configurationManager.model.HoaderData;
import com.mg.configurationManager.model.SiteDto;
import com.mg.configurationManager.model.SiteRuleDto;

@Service
public class RuleEngine {

	@Autowired
	private ForceAIprocessor forceAIprocessor;
	@Autowired
	private SiteRuleService siteRuleService;
	@Autowired
	private SiteService siteService;
	@Autowired
	
	public void processEvent(HoaderData hoaderData)
	{
		SiteDto siteDto =siteService.getSiteByToken(hoaderData.getSiteToken());
		System.out.println("Site id found ["+siteDto.getId()+"]");
		List<SiteRuleDto> siteRuleDto = siteRuleService.getRules(siteDto.getId(),hoaderData.getEvent());
		System.out.println("Site rules for site ["+siteDto.getId()+"] size ["+siteRuleDto.size()+"]");
		for (SiteRuleDto siteRuleDto2 : siteRuleDto) {
			System.out.println("Siterule data........"+siteRuleDto2.getDefaultEmailTemplateDto());
			System.out.println("Siterule data........"+siteRuleDto2.getDefaultEmailTemplateDto().getId());
			System.out.println("Siterule data........"+siteRuleDto2.getDefaultEmailTemplateDto().getBody());
			forceAIprocessor.processEventAndAct(siteRuleDto2,hoaderData);
		}
		
	}
}
