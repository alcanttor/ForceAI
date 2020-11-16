package com.mg.configurationManager.entityService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.entity.AvailableRule;
import com.mg.configurationManager.entity.Connector;
import com.mg.configurationManager.repository.AvailableRuleRepository;

@Service
public class AvailableRuleEntityService {

	@Autowired
	private AvailableRuleRepository availableRuleRepository;
	
	public List<AvailableRule> getAllAvailableRules() {
		return availableRuleRepository.findAll();
	}

	public List<AvailableRule> getAllAvailableRulesByConnetors(Connector connector) {
		return availableRuleRepository.findByConnector(connector);
	}

	public Optional<AvailableRule> getAvailableRuleById(Integer id)
	{
		return availableRuleRepository.findById(id);
	}
}
