package com.mg.configurationManager.Service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.Service.ActionService;
import com.mg.configurationManager.model.DefaultEmailTemplateDto;
import com.mg.configurationManager.model.EmailData;
import com.mg.configurationManager.model.HoaderData;
import com.mg.configurationManager.model.UserEmailTemplateDto;

@Service
public class EmailToWishListUsers implements ActionService{

	@Autowired
	private EmailSenderService emailSenderService;
	@Override
	public void action(HoaderData hoaderData, DefaultEmailTemplateDto defaultEmailTemplateDto,
			UserEmailTemplateDto userEmailTemplateDto) {
		System.out.println("fetch users who have product ["+hoaderData.getDataMap().get("productName")+"] in the whish list");
		List<String> emails = new ArrayList<String>();
		emails.add("luna.varun@gmail.com");
		emails.add("beyond.infinite05@gmail.com");
		for (String email : emails) {
			EmailData emailData = new EmailData();
			System.out.println("some......use email template ......."+userEmailTemplateDto);
			if (userEmailTemplateDto != null && userEmailTemplateDto.getId() != null) {
				emailData.setSubject(userEmailTemplateDto.getSubject());
				emailData.setText(formEmailBody(hoaderData,userEmailTemplateDto.getBody()));
				emailData.setTo(email);
			} else {
				emailData.setSubject(defaultEmailTemplateDto.getSubject());
				emailData.setText(formEmailBody(hoaderData,defaultEmailTemplateDto.getBody()));
				emailData.setTo(email);
			}
			emailSenderService.sendEmail(emailData);
		}
		
	}

	private String formEmailBody(HoaderData hoaderData,String text) {
		String body = text;
		System.out.println("template text : "+body);
		Map<String, String> hoaderMap = hoaderData.getDataMap();
		Iterator<Map.Entry<String, String>> itr = hoaderMap.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			String toReplace = "\\{"+entry.getKey()+"\\}";
			body = body.replaceAll(toReplace,entry.getValue());
		}
		return body;
	}
}
