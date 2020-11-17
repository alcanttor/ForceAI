package com.mg.configurationManager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Site {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@ManyToOne
	private User user;
	@Enumerated(EnumType.STRING)
	private Connector connector;
	@OneToOne(cascade = CascadeType.ALL)
	private SiteToken siteToken;
	@OneToMany(mappedBy = "site")
	private List<SiteRule> siteRules;
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
	public SiteToken getSiteToken() {
		return siteToken;
	}
	public void setSiteToken(SiteToken siteToken) {
		this.siteToken = siteToken;
	}
	public List<SiteRule> getSiteRules() {
		return siteRules;
	}
	public void setSiteRules(List<SiteRule> siteRules) {
		this.siteRules = siteRules;
	}
	
	
}
