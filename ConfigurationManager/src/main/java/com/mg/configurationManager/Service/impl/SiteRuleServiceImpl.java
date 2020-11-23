package com.mg.configurationManager.Service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;
import com.mg.configurationManager.Service.SiteRuleService;
import com.mg.configurationManager.Service.SiteService;
import com.mg.configurationManager.Service.SubscriptionService;
import com.mg.configurationManager.entity.AvailableRule;
import com.mg.configurationManager.entity.Event;
import com.mg.configurationManager.entity.FixRule;
import com.mg.configurationManager.entity.Rule;
import com.mg.configurationManager.entity.RuleType;
import com.mg.configurationManager.entity.Site;
import com.mg.configurationManager.entity.SiteRule;
import com.mg.configurationManager.entityService.AvailableRuleEntityService;
import com.mg.configurationManager.entityService.SiteRuleEntityService;
import com.mg.configurationManager.exceptions.InCompleteInformation;
import com.mg.configurationManager.exceptions.SiteLimitConsumedException;
import com.mg.configurationManager.model.CreateSiteRuleDtoInput;
import com.mg.configurationManager.model.RuleDto;
import com.mg.configurationManager.model.SiteDto;
import com.mg.configurationManager.model.SiteRuleDto;
import com.mg.configurationManager.model.UserSubscriptionDto;

@Service
public class SiteRuleServiceImpl implements SiteRuleService {

	@Autowired
	private SiteRuleEntityService siteRuleEntityService;
	@Autowired
	private AvailableRuleEntityService availableRuleEntityService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private SubscriptionService subscriptionService;
	@Autowired
	private ModelMapper modelMapper;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public CreateSiteRuleDtoInput addRule(CreateSiteRuleDtoInput siteRuleDto) {
		UserSubscriptionDto userSubscriptionDto = subscriptionService
				.getSubscriptionDetailsByUserId(siteRuleDto.getSiteDto().getUser().getId());
		if (userSubscriptionDto.getRuleCreationAvailable() < 0)
			throw new SiteLimitConsumedException();
		SiteRule siteRule = new SiteRule();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		modelMapper.map(siteRuleDto, siteRule);
		Optional<AvailableRule> availableRuleOptional = availableRuleEntityService
				.getAvailableRuleById(siteRuleDto.getAvailableRuleDto().getId());
		if (!availableRuleOptional.isPresent())
			throw new InCompleteInformation("Informationa missing : No Available rule id in input");
		SiteDto siteDto = siteService.getSitesById(siteRuleDto.getSiteDto().getId());
		System.out.println("site dto found from id ["+siteRuleDto.getSiteDto().getId()+"] : "+siteDto);
		Site site = new Site();
		modelMapper.map(siteDto, site);
		AvailableRule availableRule = availableRuleOptional.get();
		List<Rule> ruleSaves = new ArrayList<Rule>();
		List<FixRule> fixRules = availableRule.getFixRules();
		int index = 0;
		String expressionTemplate = availableRule.getRuleExpression();
		for (FixRule fixRule : fixRules) {
			Rule rule = populateRuleData(fixRule, siteRuleDto.getRuleDtos());
			ruleSaves.add(rule);
		}
		siteRule.setRules(ruleSaves);
		siteRule.setAvailableRule(availableRule);
		siteRule.setSite(site);
		siteRule.setEvent(availableRule.getEvent());
		siteRule.setRuleExpression(expressionTemplate);
		SiteRule savedSiteRule = siteRuleEntityService.addRule(siteRule);
		modelMapper.map(savedSiteRule, siteRuleDto);
		subscriptionService.consumeruleCreation(siteRuleDto.getSiteDto().getUser().getId());
		return siteRuleDto;

	}

	private Rule populateRuleData(FixRule fixRule, List<RuleDto> ruleDtos) {
		Rule rule = new Rule();
		modelMapper.map(fixRule, rule);
		if (fixRule.getRuleType() == RuleType.DYNAMIC) {
			for (RuleDto ruleDto : ruleDtos) {
				if (ruleDto.getSystemParameterDto().getName().equals(fixRule.getParameter().getName())) {
					rule.setMax(ruleDto.getMax());
					rule.setMin(ruleDto.getMin());
					break;
				}
			}
		}
		return rule;
	}

	@Override
	public void deleteSiteRulebysiteRuleId(Integer siteRuleId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SiteRuleDto> getRules(Integer siteId) {
		List<SiteRule> siteRules = siteRuleEntityService.getRules(siteId);
		Type siteRulesDtosTemp = new TypeToken<List<SiteRuleDto>>() {
		}.getType();
		List<SiteRuleDto> siteRulesDto = modelMapper.map(siteRules, siteRulesDtosTemp);
		return siteRulesDto;
	}

	@Override
	public SiteRuleDto addRule(SiteRuleDto siteRuleDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SiteRuleDto updateRule(CreateSiteRuleDtoInput siteRuleDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SiteRuleDto> getRules(Integer siteId, Event event) {
		List<SiteRule> siteRules = siteRuleEntityService.getRules(siteId, event);
		System.out.println("size of the rule list " + siteRules.size());
		// System.out.println("test
		// print..."+siteRules.get(0).getAvailableRule().getDefaultEmailTemplate().getId());
		Type siteRulesDtosTemp = new TypeToken<List<SiteRuleDto>>() {
		}.getType();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		List<SiteRuleDto> siteRulesDto = modelMapper.map(siteRules, siteRulesDtosTemp);
		// System.out.println("test
		// print..."+siteRulesDto.get(0).getAvailableRuleDto().getDefaultEmailTemplateDto().getId());
		return siteRulesDto;
	}

}
