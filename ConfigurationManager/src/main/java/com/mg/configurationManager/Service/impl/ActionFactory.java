package com.mg.configurationManager.Service.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.Service.ActionService;

@Service
public class ActionFactory implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public ActionService getActionService(String name) {
		switch (name) {
		case "Email to User":
			return applicationContext.getBean(EmailToUser.class);
		case "Email to Wish list User":
			return applicationContext.getBean(EmailToWishListUsers.class);
		case "Email to Admin":
			return applicationContext.getBean(EmailToAdmin.class);
		default:
			break;
		}
		return null;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
