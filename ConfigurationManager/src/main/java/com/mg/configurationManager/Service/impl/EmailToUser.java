package com.mg.configurationManager.Service.impl;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.Service.ActionService;
import com.mg.configurationManager.model.DefaultEmailTemplateDto;
import com.mg.configurationManager.model.EmailData;
import com.mg.configurationManager.model.HoaderData;
import com.mg.configurationManager.model.UserEmailTemplateDto;
@Service
public class EmailToUser implements ActionService {

	@Autowired
	private EmailSenderService emailSenderService;

	@Override
	public void action(HoaderData hoaderData, DefaultEmailTemplateDto defaultEmailTemplateDto,
			UserEmailTemplateDto userEmailTemplateDto) {
		EmailData emailData = new EmailData();
System.out.println("step on : "+defaultEmailTemplateDto);
System.out.println("step on : "+userEmailTemplateDto);
		if (userEmailTemplateDto != null) {
			emailData.setSubject(userEmailTemplateDto.getSubject());
			emailData.setText(formEmailBody(hoaderData,defaultEmailTemplateDto.getBody()));
			emailData.setTo(hoaderData.getDataMap().get("UserEmail"));
		} else {
			emailData.setSubject(defaultEmailTemplateDto.getSubject());
			emailData.setText(formEmailBody(hoaderData,defaultEmailTemplateDto.getBody()));
			emailData.setTo(hoaderData.getDataMap().get("UserEmail"));
		}
		emailSenderService.sendEmail(emailData);
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