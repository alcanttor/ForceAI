package com.mg.configurationManager.Service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;
import com.mg.configurationManager.Service.AvailableRuleService;
import com.mg.configurationManager.entity.AvailableRule;
import com.mg.configurationManager.entity.Connector;
import com.mg.configurationManager.entityService.AvailableRuleEntityService;
import com.mg.configurationManager.exceptions.NotImplementedException;
import com.mg.configurationManager.model.AvailableRuleDto;

@Service
public class AvailableRuleServiceImpl implements AvailableRuleService{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AvailableRuleEntityService availableRuleEntityService;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<AvailableRuleDto> getAllAvailableRules() {
		List<AvailableRule> availableRules = availableRuleEntityService.getAllAvailableRules();
		Type listavailableRules = new TypeToken<List<AvailableRuleDto>>() {}.getType();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		List<AvailableRuleDto> allRules = modelMapper.map(availableRules,listavailableRules);
		return allRules;
	}

	@Override
	public List<AvailableRuleDto> getAllAvailableRulesByConnetors(Connector connector) {
		throw new NotImplementedException();
	}

}
