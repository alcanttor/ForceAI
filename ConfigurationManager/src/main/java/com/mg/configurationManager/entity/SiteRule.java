package com.mg.configurationManager.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class SiteRule {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String description;
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Rule> rules;
	@Enumerated(EnumType.STRING)
	private Event event;
	@OneToMany
	private List<Action> actions;
	private String ruleExpression;
	@ManyToOne
	private Site site;
	@OneToOne
	private AvailableRule availableRule;
	@OneToOne
	private UserEmailTemplate UserEmailTemplate;
	@OneToOne
	private DefaultEmailTemplate defaultEmailTemplate; // this may not required. can fetch from available rule
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Rule> getRules() {
		return rules;
	}
	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public List<Action> getActions() {
		return actions;
	}
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	public String getRuleExpression() {
		return ruleExpression;
	}
	public void setRuleExpression(String ruleExpression) {
		this.ruleExpression = ruleExpression;
	}
	public AvailableRule getAvailableRule() {
		return availableRule;
	}
	public void setAvailableRule(AvailableRule availableRule) {
		this.availableRule = availableRule;
	}
	public UserEmailTemplate getUserEmailTemplate() {
		return UserEmailTemplate;
	}
	public void setUserEmailTemplate(UserEmailTemplate UserEmailTemplate) {
		this.UserEmailTemplate = UserEmailTemplate;
	}
	public DefaultEmailTemplate getDefaultEmailTemplate() {
		return defaultEmailTemplate;
	}
	public void setDefaultEmailTemplate(DefaultEmailTemplate defaultEmailTemplate) {
		this.defaultEmailTemplate = defaultEmailTemplate;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	@Override
	public String toString() {
		return "SiteRule [id=" + id + ", name=" + name + ", description=" + description + ", rules=" + rules
				+ ", event=" + event + ", actions=" + actions + ", ruleExpression=" + ruleExpression + ", site=" + site
				+ ", availableRule=" + availableRule + ", UserEmailTemplate=" + UserEmailTemplate
				+ ", defaultEmailTemplate=" + defaultEmailTemplate + "]";
	}
	
	
}
