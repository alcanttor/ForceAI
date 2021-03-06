package com.mg.configurationManager.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserSubscription {

	@Id
	@GeneratedValue
	private Integer id;
	@OneToOne
	private Plan plan;
	@OneToOne
	private User user;
	private Integer siteSharingAllowed;
	private Integer ruleCreationAllowed;
	private Integer ruleExecutionAllowed;
	private Integer siteSharingConsumed;
	private Integer ruleCreationConsumed;
	private Integer ruleExecutionConsumed;
	private Integer siteSharingAvailable;
	private Integer ruleCreationAvailable;
	private Integer ruleExecutionAvailable;
	private Timestamp startDate;
	private Timestamp endDate;
	private SubscriptionStatus subscriptionStatus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
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
	public Integer getSiteSharingConsumed() {
		return siteSharingConsumed;
	}
	public void setSiteSharingConsumed(Integer siteSharingConsumed) {
		this.siteSharingConsumed = siteSharingConsumed;
	}
	public Integer getRuleCreationConsumed() {
		return ruleCreationConsumed;
	}
	public void setRuleCreationConsumed(Integer ruleCreationConsumed) {
		this.ruleCreationConsumed = ruleCreationConsumed;
	}
	public Integer getRuleExecutionConsumed() {
		return ruleExecutionConsumed;
	}
	public void setRuleExecutionConsumed(Integer ruleExecutionConsumed) {
		this.ruleExecutionConsumed = ruleExecutionConsumed;
	}
	public Integer getSiteSharingAvailable() {
		return siteSharingAvailable;
	}
	public void setSiteSharingAvailable(Integer siteSharingAvailable) {
		this.siteSharingAvailable = siteSharingAvailable;
	}
	public Integer getRuleCreationAvailable() {
		return ruleCreationAvailable;
	}
	public void setRuleCreationAvailable(Integer ruleCreationAvailable) {
		this.ruleCreationAvailable = ruleCreationAvailable;
	}
	public Integer getRuleExecutionAvailable() {
		return ruleExecutionAvailable;
	}
	public void setRuleExecutionAvailable(Integer ruleExecutionAvailable) {
		this.ruleExecutionAvailable = ruleExecutionAvailable;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public SubscriptionStatus getSubscriptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
