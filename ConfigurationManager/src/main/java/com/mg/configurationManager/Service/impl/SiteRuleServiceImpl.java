package com.mg.configurationManager.Service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;
import com.mg.configurationManager.Service.SiteRuleService;
import com.mg.configurationManager.Service.SubscriptionService;
import com.mg.configurationManager.entity.SiteRule;
import com.mg.configurationManager.entityService.SiteRuleEntityService;
import com.mg.configurationManager.exceptions.SiteLimitConsumedException;
import com.mg.configurationManager.model.AvailableRuleDto;
import com.mg.configurationManager.model.CreateSiteRuleDtoInput;
import com.mg.configurationManager.model.SiteRuleDto;
import com.mg.configurationManager.model.UserSubscriptionDto;

@Service
public class SiteRuleServiceImpl implements SiteRuleService {

	@Autowired
	private SiteRuleEntityService siteRuleEntityService;

	@Autowired
	private SubscriptionService subscriptionService;
	@Autowired
	private ModelMapper modelMapper;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public CreateSiteRuleDtoInput addRule(CreateSiteRuleDtoInput siteRuleDto) {
		UserSubscriptionDto userSubscriptionDto = subscriptionService
				.getSubscriptionDetailsByUserId(siteRuleDto.getSiteDto().getUser().getId());
		if (userSubscriptionDto.getRuleCreationAvailable() > 0) {
			SiteRule siteRule = new SiteRule();
			modelMapper.map(siteRuleDto, siteRule);
			SiteRule savedSiteRule = siteRuleEntityService.addRule(siteRule);
			modelMapper.map(savedSiteRule, siteRuleDto);
			subscriptionService.consumeruleCreation(siteRuleDto.getSiteDto().getUser().getId());
			return siteRuleDto;
		} else {
			throw new SiteLimitConsumedException();
		}
	}

	@Override
	public void deleteSiteRulebysiteRuleId(Integer siteRuleId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SiteRuleDto> getRules(Integer siteId) {
		List<SiteRule> siteRules = siteRuleEntityService.getRules(siteId);
		Type siteRulesDtosTemp = new TypeToken<List<SiteRuleDto>>() {}.getType();
		List<SiteRuleDto> siteRulesDto = modelMapper.map(siteRules,siteRulesDtosTemp);
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

}
