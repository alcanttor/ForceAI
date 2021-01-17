package com.mg.notification.Service.impl;

import org.springframework.stereotype.Service;

import com.mg.notification.Service.ActionService;
import com.mg.notification.model.DefaultEmailTemplateDto;
import com.mg.notification.model.HoaderData;
import com.mg.notification.model.UserEmailTemplateDto;

@Service
public class EmailToAdmin implements ActionService{


	@Override
	public void action(HoaderData hoaderData, DefaultEmailTemplateDto defaultEmailTemplateDto,
			UserEmailTemplateDto userEmailTemplateDto) {
		// TODO Auto-generated method stub
		
	}

}
