package com.mg.configurationManager.model;

import org.springframework.stereotype.Component;

import com.mg.configurationManager.entity.Connector;
import com.mg.configurationManager.entity.User;

@Component
public class SiteDto {

	private Integer id;
	private String name;
	private User user;
	private Connector connector;
	private SiteTokenDto siteTokenDto;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Connector getConnector() {
		return connector;
	}
	public void setConnector(Connector connector) {
		this.connector = connector;
	}
	public SiteTokenDto getSiteTokenDto() {
		return siteTokenDto;
	}
	public void setSiteTokenDto(SiteTokenDto siteTokenDto) {
		this.siteTokenDto = siteTokenDto;
	}

}
