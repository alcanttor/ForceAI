package com.mg.door.Service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mg.door.entity.Event;
import com.mg.door.model.RuleDto;
import com.mg.door.model.SiteDto;
import com.mg.door.model.SiteRuleDto;
@FeignClient(name="config-service")
@RibbonClient(name="config-service")
public interface SiteService {
/*
	public SiteDto addSite(Integer userId, SiteDto siteDto) throws SiteLimitConsumedException;
	public List<SiteDto> getSitesByUserName(String username);
	public List<SiteDto> getSitesByUserId(Integer userId);
	public SiteDto getSitesById(Integer siteId);
	public SiteDto getSitesBySiteName(String siteName);
	public void deleteSiteByName(String siteName);
	public SiteDto updateSiteById(SiteDto siteDto);
	public void deleteSiteById(Integer siteId);*/
	@GetMapping("/siteByToken/{siteToken}")
	public SiteDto getSiteByToken(@PathVariable String siteToken);
	@GetMapping("/SiteRuleByEvent/{siteId}/{event}")
	public List<SiteRuleDto> getRules(@PathVariable Integer siteId, @PathVariable Event event);
	@GetMapping("/Rule/{ruleId}")
	public RuleDto getRuleById(@PathVariable int ruleId);
	@GetMapping("/SubscribeToPlan/{siteToken}")
	public com.mg.door.model.UserSubscriptionDto getSubscriptionData(@PathVariable String siteToken);
	@GetMapping("/SubscribeToPlan/{siteToken}")
	public void consumeExecutionCount(@PathVariable String siteToken);

	
}

