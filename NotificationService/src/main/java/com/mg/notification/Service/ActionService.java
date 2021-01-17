package com.mg.notification.Service;

import com.mg.notification.model.DefaultEmailTemplateDto;
import com.mg.notification.model.HoaderData;
import com.mg.notification.model.UserEmailTemplateDto;

public interface ActionService {

	public void action(HoaderData hoaderData, DefaultEmailTemplateDto defaultEmailTemplateDto, UserEmailTemplateDto userEmailTemplateDto);
}
