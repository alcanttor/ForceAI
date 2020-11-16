package com.mg.configurationManager.Service;

import java.util.List;

import com.mg.configurationManager.model.UserEmailTemplateDto;

public interface UserEmailTemplateService {

	public UserEmailTemplateDto getEmailTemplateById(Integer id);
	public List<UserEmailTemplateDto> getEmailTemplateByIdUserAndAvailableRule(Integer userId, Integer availableRuleId);
	public UserEmailTemplateDto createEmailTemplate(UserEmailTemplateDto userEmailTemplateDto);
	public UserEmailTemplateDto updateEmailTemplate(UserEmailTemplateDto userEmailTemplateDto,Boolean merge);
	public void deleteEmailTemplate(Integer id);

}
