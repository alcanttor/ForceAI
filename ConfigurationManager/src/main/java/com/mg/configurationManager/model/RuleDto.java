package com.mg.configurationManager.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mg.configurationManager.entity.Operation;
import com.mg.configurationManager.entity.RuleType;

@Component
public class RuleDto {

	private Integer id;
	private SystemParametersDto systemParameterDto;
	private Operation operation;
	private String min;
	private String max;
	private RuleType ruleType;
	private List<SystemParametersDto> systemPametersDto;

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

	public List<SystemParametersDto> getSystemPametersDto() {
		return systemPametersDto;
	}

	public void setSystemPametersDto(List<SystemParametersDto> systemPametersDto) {
		this.systemPametersDto = systemPametersDto;
	}
}
