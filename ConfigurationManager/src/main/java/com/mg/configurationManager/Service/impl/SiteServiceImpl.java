package com.mg.configurationManager.Service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.Service.SiteService;
import com.mg.configurationManager.Service.SubscriptionService;
import com.mg.configurationManager.entity.Site;
import com.mg.configurationManager.entity.SiteToken;
import com.mg.configurationManager.entity.User;
import com.mg.configurationManager.entityService.SiteEntityService;
import com.mg.configurationManager.exceptions.SiteLimitConsumedException;
import com.mg.configurationManager.model.SiteDto;
import com.mg.configurationManager.model.UserDto;
import com.mg.configurationManager.model.UserSubscriptionDto;

@Service
public class SiteServiceImpl implements SiteService{

	@Autowired
	private SiteEntityService siteEntityService;
	@Autowired
	private SubscriptionService subscriptionService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserService userService;
	@Override
	public SiteDto addSite(Integer userId, SiteDto siteDto) throws SiteLimitConsumedException {
		UserSubscriptionDto userSubscriptionDto = subscriptionService.getSubscriptionDetailsByUserId(userId);
		if (userSubscriptionDto.getSiteSharingAvailable() > 0)
		{
			Site site = new Site();
			SiteToken siteToken = new SiteToken();
			siteToken.setToken(siteDto.getName()+"-"+System.currentTimeMillis()+"-"+Math.random());
			siteToken.setExpitredOn(userSubscriptionDto.getEndDate());
			modelMapper.map(siteDto,site);
			UserDto userDto = userService.getUserById(userId);
			User user = new User();
			modelMapper.map(userDto,user);
			site.setUser(user);
			site.setSiteToken(siteToken);
			site = siteEntityService.createSite(site);
			subscriptionService.consumeSiteSharing(userId);
			modelMapper.map(site,siteDto);
			return siteDto;
		}
		else
		{
			throw new SiteLimitConsumedException();
		}
		
	}

	@Override
	public List<SiteDto> getSitesByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SiteDto> getSitesByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SiteDto getSitesById(Integer siteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SiteDto getSitesBySiteName(String siteName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSiteByName(String siteName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SiteDto updateSiteById(SiteDto siteDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSiteById(Integer siteId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SiteDto getSiteByToken(String siteToken) {
		Site site = siteEntityService.getSiteByToken(siteToken);
		System.out.println("site from toke : "+site);
		SiteDto siteDto = new SiteDto();
		modelMapper.map(site,siteDto);
		return siteDto;
	}

}
