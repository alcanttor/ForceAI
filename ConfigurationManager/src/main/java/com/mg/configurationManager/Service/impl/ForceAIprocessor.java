package com.mg.configurationManager.Service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.entity.Rule;
import com.mg.configurationManager.entityService.RuleEntityService;
import com.mg.configurationManager.model.ActionDto;
import com.mg.configurationManager.model.HoaderData;
import com.mg.configurationManager.model.RuleDto;
import com.mg.configurationManager.model.SiteRuleDto;

@Service
public class ForceAIprocessor {

	@Autowired
	private RuleSolver rulesolver;
	@Autowired
	private RuleEntityService ruleEntityService;
	@Autowired
	private ModelMapper modelmapper;
	@Autowired
	private ForceAIActionService forceAIActionService;
	
	@Async
	public void processEventAndAct(SiteRuleDto siteRuleDto, HoaderData hoaderData) {
		String ruleExpression = siteRuleDto.getRuleExpression();
		String andRulesFromExpressions[] = ruleExpression.split("&&");
		for(int i = 0 ; i <andRulesFromExpressions.length ; i++)
		{
			System.out.println("Solving all rules by rule ["+andRulesFromExpressions[i]+"]");
			Rule rule = ruleEntityService.getRuleById(Integer.parseInt(andRulesFromExpressions[i]));
			RuleDto ruleDto = new RuleDto();
			modelmapper.map(rule,ruleDto);
			if (!rulesolver.solve(ruleDto, hoaderData))
			{
				System.out.println("Rule ["+ruleDto.getId()+"] is failed");
				return;
			}
		}
		List<ActionDto> actions = siteRuleDto.getActionsDto();
		System.out.println("action found for the Site ["+siteRuleDto.getId()+"] and event ["+hoaderData.getEvent()+"] size ["+actions.size()+"]");
		System.out.println("default email template : "+siteRuleDto.getAvailableRuleDto().getDefaultEmailTemplateDto());
		for (ActionDto actionDto : actions) {
			System.out.println("Actions.... "+actionDto);
			
			forceAIActionService.doAction(actionDto,hoaderData,siteRuleDto.getAvailableRuleDto().getDefaultEmailTemplateDto(),siteRuleDto.getUserEmailTemplateDto());
		}
	}

}
