package com.mg.configurationManager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Plan {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String description;
	private Integer siteSharingAllowed;
	private Integer ruleCreationAllowed;
	private Integer ruleExecutionAllowed;
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
	
	public Integer getSiteSharingAllowed() {
		return siteSharingAllowed;
	}
	public void setSiteSharingAllowed(Integer siteSharingAllowed) {
		this.siteSharingAllowed = siteSharingAllowed;
	}
	
	public Integer getRuleCreationAllowed() {
		return ruleCreationAllowed;
	}
	public void setRuleCreationAllowed(Integer ruleCreationAllowed) {
		this.ruleCreationAllowed = ruleCreationAllowed;
	}
	public Integer getRuleExecutionAllowed() {
		return ruleExecutionAllowed;
	}
	public void setRuleExecutionAllowed(Integer ruleExecutionAllowed) {
		this.ruleExecutionAllowed = ruleExecutionAllowed;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
