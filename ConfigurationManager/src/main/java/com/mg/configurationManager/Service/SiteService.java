package com.mg.configurationManager.Service;

import java.util.List;

import com.mg.configurationManager.model.SiteDto;

public interface SiteService {

	public SiteDto addSite(SiteDto siteDto);
	public List<SiteDto> getSitesByUserName(String username);
	public List<SiteDto> getSitesByUserId(Integer userId);
	public SiteDto getSitesById(Integer siteId);
	public SiteDto getSitesBySiteName(String siteName);
	public void deleteSiteByName(String siteName);
}