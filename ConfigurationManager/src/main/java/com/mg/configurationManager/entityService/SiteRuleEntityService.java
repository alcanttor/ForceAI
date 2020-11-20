package com.mg.configurationManager.entityService;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;
import com.mg.configurationManager.entity.AvailableRule;
import com.mg.configurationManager.entity.Event;
import com.mg.configurationManager.entity.FixRule;
import com.mg.configurationManager.entity.Rule;
import com.mg.configurationManager.entity.Site;
import com.mg.configurationManager.entity.SiteRule;
import com.mg.configurationManager.exceptions.InCompleteInformation;
import com.mg.configurationManager.repository.SiteRuleRepository;

@Service
public class SiteRuleEntityService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SiteRuleRepository siteRuleRepository;
	
	@Autowired
	private AvailableRuleEntityService availableRuleEntityService;
	
	@Autowired
	private RuleEntityService ruleEntityService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SiteEntityService siteEntityService;
	
	@Transactional
	public SiteRule addRule(SiteRule siteRule) {
		Optional<AvailableRule> availableRuleOptional = availableRuleEntityService.getAvailableRuleById(siteRule.getAvailableRule().getId());
		AvailableRule availableRule = null;
		if(availableRuleOptional.isPresent())
		{
			availableRule = availableRuleOptional.get();
		}
		else
		{
			throw new  InCompleteInformation("Informationa missing : No Available rule id in input");
		}
		List<FixRule> fixRules = availableRule.getFixRules();
		Type rulestoSave = new TypeToken<List<Rule>>() {}.getType();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		List<Rule> ruleList = modelMapper.map(fixRules,rulestoSave);
		List<Rule> ruleSaves = ruleEntityService.createRule(ruleList);
		Site site = siteEntityService.getSiteById(siteRule.getSite().getId());
		siteRule.setRules(ruleSaves);
		siteRule.setAvailableRule(availableRule);
		siteRule.setSite(site);
		siteRule.setEvent(availableRule.getEvent());
		String expressionTemplate = availableRule.getRuleExpression();
		int index = 0;
		for (FixRule fixRule : fixRules) {
			expressionTemplate = expressionTemplate.replaceAll(""+fixRule.getId(), ""+ruleSaves.get(index).getId());
			index++;
		}
		siteRule.setRuleExpression(expressionTemplate);
		//siteRule.setDefaultEmailTemplate(availableRule.getDefaultEmailTemplate());
		//enable trigger on plugin
		return siteRuleRepository.save(siteRule);
	}

	public void deleteSiteRulebysiteRuleId(Integer siteRuleId) {
		// TODO Auto-generated method stub
		
	}

	public List<SiteRule> getRules(Integer siteId) {
		List<SiteRule> siteRules = siteRuleRepository.findBySiteId(siteId);
		for (SiteRule siteRule : siteRules) {
			siteRule.getRules();
		}
		return siteRules;
	}

	public List<SiteRule> getRules(Integer siteId, Event event) {
		List<SiteRule> siteRules = siteRuleRepository.findBySiteIdAndEvent(siteId,event);
		for (SiteRule siteRule : siteRules) {
			siteRule.getRules();
			siteRule.getAvailableRule().getDefaultEmailTemplate();
		}
		return siteRules;
	}

}
