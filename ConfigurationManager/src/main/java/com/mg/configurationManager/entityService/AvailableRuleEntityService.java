package com.mg.configurationManager.entityService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.entity.AvailableRule;
import com.mg.configurationManager.entity.Connector;
import com.mg.configurationManager.exceptions.NotImplementedException;
import com.mg.configurationManager.repository.AvailableRuleRepository;

@Service
public class AvailableRuleEntityService {

	@Autowired
	private AvailableRuleRepository availableRuleRepository;
	
	public List<AvailableRule> getAllAvailableRules() {
		return availableRuleRepository.findAll();
	}

	public List<AvailableRule> getAllAvailableRulesByConnetors(Connector connector) {
		throw new NotImplementedException();
	}

}
