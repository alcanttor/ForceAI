package com.mg.configurationManager.Service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.Service.SiteRuleService;
import com.mg.configurationManager.entity.SiteRule;
import com.mg.configurationManager.entityService.SiteRuleEntityService;
import com.mg.configurationManager.model.CreateSiteRuleDtoInput;
import com.mg.configurationManager.model.SiteRuleDto;

@Service
public class SiteRuleServiceImpl  implements SiteRuleService{

	@Autowired
	private SiteRuleEntityService siteRuleEntityService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public SiteRuleDto addRule(CreateSiteRuleDtoInput siteRuleDto) {
		SiteRule siteRule = new SiteRule();
		logger.info("received............................................ : "+siteRuleDto);
		modelMapper.map(siteRuleDto,siteRule);
		logger.info("mapped received : "+siteRule);
		SiteRule savedSiteRule = siteRuleEntityService.addRule(siteRule);
		logger.info("mapped received : "+savedSiteRule);
		modelMapper.map(savedSiteRule,siteRuleDto);
		return null;
	}

	@Override
	public void deleteSiteRulebysiteRuleId(Integer siteRuleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SiteRuleDto> getRules(Integer siteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SiteRuleDto addRule(SiteRuleDto siteRuleDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
