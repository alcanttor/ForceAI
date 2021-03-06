package com.mg.configurationManager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mg.configurationManager.Service.SiteRuleService;
import com.mg.configurationManager.entity.Event;
import com.mg.configurationManager.model.CreateSiteRuleDtoInput;
import com.mg.configurationManager.model.SiteRuleDto;

@RestController
public class SiteRuleController {

	@Autowired
	private SiteRuleService siteRuleService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = "/SiteRule/{siteId}")
	public List<SiteRuleDto> getSiteRules(@PathVariable(name = "siteId") Integer siteId) {
		return siteRuleService.getRules(siteId);
	}

	@PostMapping(value = "/SiteRule")
	public CreateSiteRuleDtoInput addSiteRules(@RequestBody CreateSiteRuleDtoInput siteRuleDto) {
		logger.info("from controller ......................"+siteRuleDto);
		return siteRuleService.addRule(siteRuleDto);
	}
	
	@GetMapping(value = "/SiteRuleByEvent/{siteId}/{event}")
	public List<SiteRuleDto> getRulesByEvent(@PathVariable(name = "siteId") Integer siteId,@PathVariable(name = "event") Event event)
	{
	 return siteRuleService.getRules(siteId,  event);
	}
}
