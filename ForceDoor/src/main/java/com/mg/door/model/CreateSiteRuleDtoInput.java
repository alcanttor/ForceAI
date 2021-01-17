package com.mg.door.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CreateSiteRuleDtoInput {

	private String name;
	private String description;
	private List<ActionDto> actionsDto;
	private AvailableRuleDto availableRuleDto;
	private SiteDto siteDto;
	private List<RuleDto> ruleDtos;
	private UserEmailTemplateDto userEmailTemplateDto;
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
	public List<ActionDto> getActionsDto() {
		return actionsDto;
	}
	public void setActionsDto(List<ActionDto> actionsDto) {
		this.actionsDto = actionsDto;
	}
	public AvailableRuleDto getAvailableRuleDto() {
		return availableRuleDto;
	}
	public void setAvailableRuleDto(AvailableRuleDto availableRuleDto) {
		this.availableRuleDto = availableRuleDto;
	}
	
	public SiteDto getSiteDto() {
		return siteDto;
	}
	public void setSiteDto(SiteDto siteDto) {
		this.siteDto = siteDto;
	}
	
	public UserEmailTemplateDto getUserEmailTemplateDto() {
		return userEmailTemplateDto;
	}
	public void setUserEmailTemplateDto(UserEmailTemplateDto userEmailTemplateDto) {
		this.userEmailTemplateDto = userEmailTemplateDto;
	}
	
	
	public List<RuleDto> getRuleDtos() {
		return ruleDtos;
	}
	public void setRuleDtos(List<RuleDto> ruleDtos) {
		this.ruleDtos = ruleDtos;
	}
	@Override
	public String toString() {
		return "CreateSiteRuleDtoInput [name=" + name + ", description=" + description + ", actionsDto=" + actionsDto
				+ ", availableRuleDto=" + availableRuleDto + "]";
	}
	
	
	
}
