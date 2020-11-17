package com.mg.configurationManager.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.Service.SiteRuleService;
import com.mg.configurationManager.Service.SiteService;
import com.mg.configurationManager.model.HoaderData;
import com.mg.configurationManager.model.RuleDto;
import com.mg.configurationManager.model.SiteDto;
import com.mg.configurationManager.model.SiteRuleDto;

@Service
public class RuleEngine {

	@Autowired
	RuleSolver ruleSolver;
	@Autowired
	SiteRuleService siteRuleService;
	@Autowired
	SiteService siteService;
	public void processEvent(HoaderData hoaderData)
	{
		SiteDto siteDto =siteService.getSiteByToken(hoaderData.getSiteToken());
		System.out.println("Site id found ["+siteDto.getId()+"]");
		List<SiteRuleDto> siteRuleDto = siteRuleService.getRules(siteDto.getId());
		System.out.println("Site rules for site ["+siteDto.getId()+"] size ["+siteRuleDto.size()+"]");
		List<RuleDto> rules = siteRuleDto.get(0).getRulesDto();
		Boolean result = ruleSolver.solve(rules, hoaderData);
		System.out.println("Result of the rule is  : "+result);
	}
}
