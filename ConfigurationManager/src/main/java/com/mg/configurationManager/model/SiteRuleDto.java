package com.mg.configurationManager.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mg.configurationManager.entity.Event;

@Component
public class SiteRuleDto {

	private Integer id;
	private String name;
	private String description;
	private List<RuleDto> rulesDto;
	private Event event;
	private List<ActionDto> actionsDto;
	private String ruleExpression;
	private AvailableRuleDto availableRuleDto;
	private UserEmailTemplateDto UserEmailTemplateDto;
	//private DefaultEmailTemplateDto defaultEmailTemplateDto;

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

	public List<RuleDto> getRulesDto() {
		return rulesDto;
	}

	public void setRulesDto(List<RuleDto> rulesDto) {
		this.rulesDto = rulesDto;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<ActionDto> getActionsDto() {
		return actionsDto;
	}

	public void setActionsDto(List<ActionDto> actionsDto) {
		this.actionsDto = actionsDto;
	}

	public String getRuleExpression() {
		return ruleExpression;
	}

	public void setRuleExpression(String ruleExpression) {
		this.ruleExpression = ruleExpression;
	}

	public AvailableRuleDto getAvailableRuleDto() {
		return availableRuleDto;
	}

	public void setAvailableRuleDto(AvailableRuleDto availableRuleDto) {
		this.availableRuleDto = availableRuleDto;
	}

	public UserEmailTemplateDto getUserEmailTemplateDto() {
		return UserEmailTemplateDto;
	}

	public void setUserEmailTemplateDto(UserEmailTemplateDto userEmailTemplateDto) {
		UserEmailTemplateDto = userEmailTemplateDto;
	}


}
