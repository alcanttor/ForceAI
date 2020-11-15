package com.mg.configurationManager.entityService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.entity.Rule;
import com.mg.configurationManager.exceptions.NoElementFoundException;
import com.mg.configurationManager.repository.RuleRepository;

@Service
public class RuleEntityService {

	@Autowired
	private RuleRepository ruleRepositor;
	
	public Rule getRuleById(Integer id)
	{
		return ruleRepositor.findById(id).orElseThrow(()->new NoElementFoundException(id));
	}

	public Rule createRule(Rule rule) {
		return ruleRepositor.save(rule);
	}

	public List<Rule> createRule(List<Rule> rules) {
		Iterable<Rule> rulesIterable = rules;
		return ruleRepositor.saveAll(rulesIterable);
	}
	
	public Rule updateRule(Rule rule, Boolean create) throws NoElementFoundException{
		Optional<Rule> ruleOptional = ruleRepositor.findById(rule.getId());
		if(ruleOptional.isPresent())
		{
			Rule ruleToSave = ruleOptional.get();
			ruleToSave.setId(rule.getId());
			return ruleRepositor.save(ruleToSave);
		}
		else
		{
			if(create)
				return createRule(rule);
			else
				throw new NoElementFoundException(rule.getId());
		}	
	}

	public void deleteRule(Integer id) {
		ruleRepositor.deleteById(id);
	}
}
