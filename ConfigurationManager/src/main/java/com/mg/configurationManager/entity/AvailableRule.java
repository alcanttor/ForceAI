package com.mg.configurationManager.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class AvailableRule {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Event event;
	private String ruleExpression;
	@OneToMany(fetch = FetchType.EAGER)
	private List<FixRule> fixRules;
	@ManyToMany
	private List<Action> actions;
	@OneToOne
	private DefaultEmailTemplate defaultEmailTemplate;
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
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public String getRuleExpression() {
		return ruleExpression;
	}
	public void setRuleExpression(String ruleExpression) {
		this.ruleExpression = ruleExpression;
	}
	public List<FixRule> getFixRules() {
		return fixRules;
	}
	public void setFixRules(List<FixRule> fixRules) {
		this.fixRules = fixRules;
	}
	public List<Action> getActions() {
		return actions;
	}
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	public DefaultEmailTemplate getDefaultEmailTemplate() {
		return defaultEmailTemplate;
	}
	public void setDefaultEmailTemplate(DefaultEmailTemplate defaultEmailTemplate) {
		this.defaultEmailTemplate = defaultEmailTemplate;
	}
	@Override
	public String toString() {
		return "AvailableRule [id=" + id + ", name=" + name + ", event=" + event + ", ruleExpression=" + ruleExpression
				+ ", fixRules=" + fixRules + ", actions=" + actions + ", defaultEmailTemplate=" + defaultEmailTemplate
				+ "]";
	}
	
	
}
