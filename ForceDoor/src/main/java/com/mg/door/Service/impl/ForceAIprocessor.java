package com.mg.door.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mg.door.Service.SiteService;
import com.mg.door.model.HoaderData;
import com.mg.door.model.NotificationData;
import com.mg.door.model.RuleDto;
import com.mg.door.model.SiteRuleDto;

@Service
public class ForceAIprocessor {

	@Autowired
	private RuleSolver rulesolver;
	@Autowired
	private SiteService ruleService;
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate ;
	
	public void processEventAndAct(SiteRuleDto siteRuleDto, HoaderData hoaderData) {
		String ruleExpression = siteRuleDto.getRuleExpression();
		String andRulesFromExpressions[] = ruleExpression.split("&&");
		for(int i = 0 ; i <andRulesFromExpressions.length ; i++)
		{
			System.out.println("Solving all rules by rule ["+andRulesFromExpressions[i]+"]");
			RuleDto ruleDto = ruleService.getRuleById(Integer.parseInt(andRulesFromExpressions[i]));
			if (!rulesolver.solve(ruleDto, hoaderData))
			{
				System.out.println("Rule ["+ruleDto.getId()+"] is failed");
				return;
			}
		}
		NotificationData notificationData = new NotificationData();
		notificationData.setHoaderData(hoaderData);
		notificationData.setSiteRuleDto(siteRuleDto);
		System.out.println("push this to queue....."+notificationData);
		//jmsMessagingTemplate.convertAndSend("", payload);
		jmsMessagingTemplate.convertAndSend("notification", new Gson().toJson(notificationData));
	}

}
