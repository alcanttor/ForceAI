package com.mg.notification.model;

import org.springframework.stereotype.Component;

import com.mg.notification.entity.Operation;
import com.mg.notification.entity.RuleType;

@Component
public class FixRuleDto {

	private Integer id;
	private SystemParametersDto systemParameterDto;
	private Operation operation;
	private String min;
	private String max;
	private RuleType ruleType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public SystemParametersDto getSystemParameterDto() {
		return systemParameterDto;
	}
	public void setSystemParameterDto(SystemParametersDto systemParameterDto) {
		this.systemParameterDto = systemParameterDto;
	}
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public RuleType getRuleType() {
		return ruleType;
	}
	public void setRuleType(RuleType ruleType) {
		this.ruleType = ruleType;
	}
	
	
}
