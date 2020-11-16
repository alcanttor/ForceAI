package com.mg.configurationManager.Service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;
import com.mg.configurationManager.Service.UserEmailTemplateService;
import com.mg.configurationManager.entity.UserEmailTemplate;
import com.mg.configurationManager.entityService.UserEmailTemplateEntityService;
import com.mg.configurationManager.model.UserEmailTemplateDto;

@Service
public class UserEmailTemplateServiceImpl implements UserEmailTemplateService{

	@Autowired
	private UserEmailTemplateEntityService userEmailTemplateEntityService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserEmailTemplateDto getEmailTemplateById(Integer id) {
		UserEmailTemplate userEmailTemplate = userEmailTemplateEntityService.getUserEmailTemplateById(id);
		UserEmailTemplateDto userEmailTemplateDto = new UserEmailTemplateDto();
		modelMapper.map(userEmailTemplate,userEmailTemplateDto);
		return userEmailTemplateDto;
	}

	@Override
	public UserEmailTemplateDto createEmailTemplate(UserEmailTemplateDto userEmailTemplateDto) {
		UserEmailTemplate userEmailTemplate = new UserEmailTemplate();
		modelMapper.map(userEmailTemplateDto,userEmailTemplate);
		userEmailTemplate = userEmailTemplateEntityService.createEmailTemplate(userEmailTemplate);
		modelMapper.map(userEmailTemplate,userEmailTemplateDto);
		return userEmailTemplateDto;
	}

	@Override
	public UserEmailTemplateDto updateEmailTemplate(UserEmailTemplateDto userEmailTemplateDto, Boolean merge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmailTemplate(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserEmailTemplateDto> getEmailTemplateByIdUserAndAvailableRule(Integer userId,
			Integer availableRuleId) {
		List<UserEmailTemplate> userEmailTemplates = userEmailTemplateEntityService.getEmailTemplateByIdUserAndAvailableRule(userId,availableRuleId);
		Type listavailableRules = new TypeToken<List<UserEmailTemplateDto>>() {}.getType();
		List<UserEmailTemplateDto> userEmailTemplatesDto = modelMapper.map(userEmailTemplates,listavailableRules);
		return userEmailTemplatesDto;
	}

}
