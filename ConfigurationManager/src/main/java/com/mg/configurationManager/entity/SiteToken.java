package com.mg.configurationManager.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SiteToken {

	@Id
	@GeneratedValue
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
