package com.mg.configurationManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mg.configurationManager.Service.AvailableRuleService;
import com.mg.configurationManager.entity.Connector;
import com.mg.configurationManager.model.AvailableRuleDto;


@RestController
public class AvailableRuleController {

	@Autowired
	private AvailableRuleService availableRuleService; 
	
	@GetMapping(value = "/AvailbleRule")
	public List<AvailableRuleDto> geAllAvailbleRule()
	{
		return availableRuleService.getAllAvailableRules();
	}
	
	@GetMapping(value = "/AvailbleRule/{connector}")
	public List<AvailableRuleDto> geAllAvailbleRule(@PathVariable(name = "connector") Connector connector)
	{
		return availableRuleService.getAllAvailableRulesByConnetors(connector);
	}
	}
