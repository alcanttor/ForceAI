package com.mg.configurationManager.Service;

import java.util.List;

import com.mg.configurationManager.model.CreateSiteRuleDtoInput;
import com.mg.configurationManager.model.SiteRuleDto;

public interface SiteRuleService {
	public SiteRuleDto addRule(SiteRuleDto siteRuleDto);
	public SiteRuleDto addRule(CreateSiteRuleDtoInput siteRuleDto);
	public void deleteSiteRulebysiteRuleId(Integer siteRuleId);
	public List<SiteRuleDto> getRules(Integer siteId);
	
}
