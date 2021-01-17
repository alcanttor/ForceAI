package com.mg.notification.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.mg.notification.model.NotificationData;

@Component
public class MessageReceiver {

	@Autowired
	private RuleActionProcessor ruleActionProcessor;

	@JmsListener(destination = "notification")
	public void receiveQueue(String text) {
		//while (true) {
			System.out.println("Message Received: " + text);
			NotificationData notificationData = new Gson().fromJson(text, NotificationData.class);
			ruleActionProcessor.processEventAndAct(notificationData.getSiteRuleDto(), notificationData.getHoaderData());
		//}
	}

}
