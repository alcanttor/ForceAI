package com.mg.configurationManager.model;

import java.sql.Timestamp;

import com.mg.configurationManager.entity.SubscriptionStatus;

public class UserSubscriptionDto {
	private Integer id;
	private PlanDto planDto;
	private UserDto userDto;
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

	public PlanDto getPlanDto() {
		return planDto;
	}

	public void setPlanDto(PlanDto planDto) {
		this.planDto = planDto;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
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

}
