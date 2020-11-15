package com.mg.configurationManager.Service;

import com.mg.configurationManager.model.SiteRuleDto;

public interface SiteRuleService {
	public SiteRuleDto addRule(SiteRuleDto siteRuleDto);
	public void deleteSiteRulebysiteRuleId(Integer siteRuleId);
}
