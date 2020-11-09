package com.mg.configurationManager.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FixRule {

	@Id
	@GeneratedValue
	private Integer id;
	@OneToOne
	private SystemParameters parameter;
	@Enumerated(EnumType.STRING)
	private Operation operation;
	private String min;
	private String max;
	@Enumerated(EnumType.STRING)
	private RuleType ruleType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public SystemParameters getParameter() {
		return parameter;
	}
	public void setParameter(SystemParameters parameter) {
		this.parameter = parameter;
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
