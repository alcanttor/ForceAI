package com.mg.configurationManager.entityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.entity.Site;
import com.mg.configurationManager.exceptions.NoElementFoundException;
import com.mg.configurationManager.repository.SiteRepository;

@Service
public class SiteEntityService {

	@Autowired
	private SiteRepository siteRepositor;
	
	public Site getSiteById(Integer id)
	{
		return siteRepositor.findById(id).orElseThrow(()->new NoElementFoundException(id));
	}

	public Site createSite(Site site) {
		return siteRepositor.save(site);
	}
/*
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
	}*/

	public Site getSiteByToken(String siteToken) {
		return siteRepositor.findBySiteTokenToken(siteToken);
	}
}
