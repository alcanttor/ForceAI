package com.mg.configurationManager.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mg.configurationManager.entity.Connector;
import com.mg.configurationManager.entity.Event;

@Component
public class AvailableRuleDto {

	private Integer id;
	private String name;
	private Event event;
	private String ruleExpression;
	private List<FixRuleDto> fixRulesDto;
	private List<ActionDto> actionsDto;
	private DefaultEmailTemplateDto defaultEmailTemplateDto;
	private Connector connector;
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
	public List<FixRuleDto> getFixRulesDto() {
		return fixRulesDto;
	}
	public void setFixRulesDto(List<FixRuleDto> fixRulesDto) {
		this.fixRulesDto = fixRulesDto;
	}
	public List<ActionDto> getActionsDto() {
		return actionsDto;
	}
	public void setActionsDto(List<ActionDto> actionsDto) {
		this.actionsDto = actionsDto;
	}
	public DefaultEmailTemplateDto getDefaultEmailTemplateDto() {
		return defaultEmailTemplateDto;
	}
	public void setDefaultEmailTemplateDto(DefaultEmailTemplateDto defaultEmailTemplateDto) {
		this.defaultEmailTemplateDto = defaultEmailTemplateDto;
	}
	public Connector getConnector() {
		return connector;
	}
	public void setConnector(Connector connector) {
		this.connector = connector;
	}
	
	
}
