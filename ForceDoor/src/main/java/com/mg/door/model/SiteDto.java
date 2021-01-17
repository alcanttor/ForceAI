package com.mg.door.model;

import org.springframework.stereotype.Component;

import com.mg.door.entity.Connector;

@Component
public class SiteDto {

	private Integer id;
	private String name;
	private UserDto userDto;
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
	
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
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
