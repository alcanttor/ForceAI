package com.mg.door.model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class SiteTokenDto {

	private Integer id;
	private String token;
	private Timestamp expitredOn;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Timestamp getExpitredOn() {
		return expitredOn;
	}
	public void setExpitredOn(Timestamp expitredOn) {
		this.expitredOn = expitredOn;
	}
	
	
}
