package com.mg.configurationManager.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.Service.ActionService;
import com.mg.configurationManager.model.ActionDto;
import com.mg.configurationManager.model.DefaultEmailTemplateDto;
import com.mg.configurationManager.model.HoaderData;
import com.mg.configurationManager.model.UserEmailTemplateDto;

@Service
public class ForceAIActionService {

	@Autowired
	private ActionFactory actionFactorty;
	public void doAction(ActionDto actionDto,HoaderData hoaderData, DefaultEmailTemplateDto defaultEmailTemplateDto, UserEmailTemplateDto userEmailTemplateDto) {
		ActionService actionService = actionFactorty.getActionService(actionDto.getName());
		takeAction(actionService,hoaderData,defaultEmailTemplateDto,userEmailTemplateDto);
	}

	private void takeAction(ActionService actionService,HoaderData hoaderData, DefaultEmailTemplateDto defaultEmailTemplateDto, UserEmailTemplateDto userEmailTemplateDto)
	{
		System.out.println("default template here : "+defaultEmailTemplateDto);
		actionService.action(hoaderData,defaultEmailTemplateDto,userEmailTemplateDto);
	}
}
