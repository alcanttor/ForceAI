package com.mg.door.model;

import org.springframework.stereotype.Component;

@Component
public class AuthorizationTokenResponse {
	private String jwt;
	private Integer userId;
	private Integer siteId;
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	
}
