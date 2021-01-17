package com.mg.notification.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.notification.Service.ActionService;
import com.mg.notification.model.ActionDto;
import com.mg.notification.model.DefaultEmailTemplateDto;
import com.mg.notification.model.HoaderData;
import com.mg.notification.model.UserEmailTemplateDto;

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
