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

import com.mg.configurationManager.Service.RuleService;
import com.mg.configurationManager.Service.SiteRuleService;
import com.mg.configurationManager.entity.Event;
import com.mg.configurationManager.model.CreateSiteRuleDtoInput;
import com.mg.configurationManager.model.RuleDto;
import com.mg.configurationManager.model.SiteRuleDto;

@RestController
public class RuleController {

	@Autowired
	private RuleService ruleService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = "/Rule/{ruleId}")
	public RuleDto getRules(@PathVariable(name = "ruleId") Integer ruleId) {
		return ruleService.getRule(ruleId);
	}
}
