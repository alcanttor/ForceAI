package com.mg.notification.model;

import org.springframework.stereotype.Component;

@Component
public class DefaultEmailTemplateDto {

	private Integer id;
	private String body;
	private String subject;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "DefaultEmailTemplateDto [id=" + id + ", body=" + body + ", subject=" + subject + ", name=" + name + "]";
	}
	
	
}
