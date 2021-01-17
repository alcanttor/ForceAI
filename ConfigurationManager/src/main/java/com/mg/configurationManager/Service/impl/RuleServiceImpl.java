package com.mg.configurationManager.Service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.Service.RuleService;
import com.mg.configurationManager.entity.Rule;
import com.mg.configurationManager.entityService.RuleEntityService;
import com.mg.configurationManager.model.RuleDto;

@Service
public class RuleServiceImpl implements RuleService{

	@Autowired
	RuleEntityService ruleEntityService;
	@Autowired
	ModelMapper modelMapper;
	@Override
	public RuleDto getRule(Integer ruleId) {
		Rule rule = ruleEntityService.getRuleById(ruleId);
		RuleDto ruleDto = new RuleDto();
		modelMapper.map(rule,ruleDto);
		return ruleDto;
	}

}
