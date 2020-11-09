package com.mg.configurationManager.model;

import org.springframework.stereotype.Component;

@Component
public class AuthorizationTokenResponse {
	private String jwt;
	private Integer userId;
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
}
