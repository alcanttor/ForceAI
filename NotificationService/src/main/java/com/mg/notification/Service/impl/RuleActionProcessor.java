package com.mg.notification.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.notification.model.ActionDto;
import com.mg.notification.model.HoaderData;
import com.mg.notification.model.SiteRuleDto;

@Service
public class RuleActionProcessor {

	@Autowired
	private ForceAIActionService forceAIActionService;	
	
	public void processEventAndAct(SiteRuleDto siteRuleDto, HoaderData hoaderData) {
		List<ActionDto> actions = siteRuleDto.getActionsDto();
		System.out.println("action found for the Site ["+siteRuleDto.getId()+"] and event ["+hoaderData.getEvent()+"] size ["+actions.size()+"]");
		System.out.println("default email template : "+siteRuleDto.getAvailableRuleDto().getDefaultEmailTemplateDto());
		for (ActionDto actionDto : actions) {
			System.out.println("Actions.... "+actionDto);
			
			forceAIActionService.doAction(actionDto,hoaderData,siteRuleDto.getAvailableRuleDto().getDefaultEmailTemplateDto(),siteRuleDto.getUserEmailTemplateDto());
		}
	}

}
