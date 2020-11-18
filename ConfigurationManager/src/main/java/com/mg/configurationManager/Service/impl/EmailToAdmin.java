package com.mg.configurationManager.Service.impl;

import org.springframework.stereotype.Service;

import com.mg.configurationManager.Service.ActionService;
import com.mg.configurationManager.model.DefaultEmailTemplateDto;
import com.mg.configurationManager.model.HoaderData;
import com.mg.configurationManager.model.UserEmailTemplateDto;

@Service
public class EmailToAdmin implements ActionService{


	@Override
	public void action(HoaderData hoaderData, DefaultEmailTemplateDto defaultEmailTemplateDto,
			UserEmailTemplateDto userEmailTemplateDto) {
		// TODO Auto-generated method stub
		
	}

}
