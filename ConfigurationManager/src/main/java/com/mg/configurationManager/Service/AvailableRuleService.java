package com.mg.configurationManager.Service;

import java.util.List;

import com.mg.configurationManager.entity.Connector;
import com.mg.configurationManager.model.AvailableRuleDto;

public interface AvailableRuleService {

	public List<AvailableRuleDto> getAllAvailableRules();
	public List<AvailableRuleDto> getAllAvailableRulesByConnetors(Connector connector);
}
