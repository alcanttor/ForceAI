package com.mg.configurationManager.Service;

import com.mg.configurationManager.model.DefaultEmailTemplateDto;
import com.mg.configurationManager.model.HoaderData;
import com.mg.configurationManager.model.UserEmailTemplateDto;

public interface ActionService {

	public void action(HoaderData hoaderData, DefaultEmailTemplateDto defaultEmailTemplateDto, UserEmailTemplateDto userEmailTemplateDto);
}
