package com.mg.configurationManager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

@Entity
public class UserEmailTemplate {

	@javax.persistence.Id
	@GeneratedValue
	private Integer Id;
	@OneToOne
	private User user;
	@OneToOne
	private AvailableRule availableRule;
	private String templateName;
	private String subject;
	private String body;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public AvailableRule getAvailableRule() {
		return availableRule;
	}
	public void setAvailableRule(AvailableRule availableRule) {
		this.availableRule = availableRule;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
}
