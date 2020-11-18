package com.mg.configurationManager.model;

import org.springframework.stereotype.Component;

@Component
public class UserEmailTemplateDto {

	private Integer Id;
	private UserDto userDto;
	private AvailableRuleDto availableRuleDto;
	private String templateName;
	private String subject;
	private String body;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public AvailableRuleDto getAvailableRuleDto() {
		return availableRuleDto;
	}
	public void setAvailableRuleDto(AvailableRuleDto availableRuleDto) {
		this.availableRuleDto = availableRuleDto;
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
	@Override
	public String toString() {
		return "UserEmailTemplateDto [Id=" + Id + ", userDto=" + userDto + ", availableRuleDto=" + availableRuleDto
				+ ", templateName=" + templateName + ", subject=" + subject + ", body=" + body + "]";
	}
	
	
}
