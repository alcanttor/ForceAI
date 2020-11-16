package com.mg.configurationManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mg.configurationManager.Service.UserEmailTemplateService;
import com.mg.configurationManager.model.UserEmailTemplateDto;


@RestController
public class EmailTemplateController {

	@Autowired
	private UserEmailTemplateService emailTemplateService;
		
	
	@GetMapping(value = "/EmailTemplateService/{id}")
	public UserEmailTemplateDto getEmailTemplateById(@PathVariable Integer id)
	{
		return emailTemplateService.getEmailTemplateById(id);
	}
	
	@GetMapping(value = "/EmailTemplateService/{userId}/{availableRuleId}")
	public List<UserEmailTemplateDto> getEmailTemplateById(@PathVariable Integer userId, @PathVariable Integer availableRuleId)
	{
		return emailTemplateService.getEmailTemplateByIdUserAndAvailableRule(userId, availableRuleId);
	}
	
	@PostMapping(value = "/EmailTemplateService")
	public UserEmailTemplateDto createEmailTemplateById(@RequestBody UserEmailTemplateDto userEmailTemplateDto)
	{
		return emailTemplateService.createEmailTemplate(userEmailTemplateDto);
	}
	
	@PostMapping(value = "/EmailTemplateServiceUpdate")
	public UserEmailTemplateDto updarteEmailTemplateById(@RequestBody UserEmailTemplateDto userEmailTemplateDto)
	{
		return emailTemplateService.updateEmailTemplate(userEmailTemplateDto,false);
	}
	
	@PostMapping(value = "/EmailTemplateServiceMege")
	public UserEmailTemplateDto mergeUserById(@RequestBody UserEmailTemplateDto userEmailTemplateDto)
	{
		return emailTemplateService.updateEmailTemplate(userEmailTemplateDto,true);
	}
	
	@DeleteMapping(value = "/EmailTemplateService/{id}")
	public UserEmailTemplateDto deleteEmailTemplateById(@PathVariable Integer id)
	{
		emailTemplateService.deleteEmailTemplate(id);
		return null;
	}
	}
