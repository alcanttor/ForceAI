package com.mg.configurationManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mg.configurationManager.Service.SiteService;
import com.mg.configurationManager.model.SiteDto;

@RestController
public class SiteController {

	@Autowired
	private SiteService siteService;

	@PostMapping("/site/{userId}")
	public SiteDto addSite(@PathVariable Integer userId, @RequestBody SiteDto siteDto) {
		return siteService.addSite(userId,siteDto);
	}

	@DeleteMapping("/site/{siteId}")
	public void deleteSite(@PathVariable Integer siteId) {
		siteService.deleteSiteById(siteId);
	}

	@GetMapping("/site/{siteId}")
	public SiteDto getSite(@PathVariable Integer siteId) {
		return siteService.getSitesById(siteId);
	}
}
