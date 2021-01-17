package com.mg.door.Service;

import com.mg.door.model.DefaultEmailTemplateDto;
import com.mg.door.model.HoaderData;
import com.mg.door.model.UserEmailTemplateDto;

public interface ActionService {

	public void action(HoaderData hoaderData, DefaultEmailTemplateDto defaultEmailTemplateDto, UserEmailTemplateDto userEmailTemplateDto);
}
