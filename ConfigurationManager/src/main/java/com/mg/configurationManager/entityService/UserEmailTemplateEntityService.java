package com.mg.configurationManager.entityService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.entity.UserEmailTemplate;
import com.mg.configurationManager.exceptions.NoElementFoundException;
import com.mg.configurationManager.repository.UserEmailTemplateRepository;

@Service
public class UserEmailTemplateEntityService {

	@Autowired
	private UserEmailTemplateRepository userEmailTemplateRepository;
	
	public UserEmailTemplate getUserEmailTemplateById(Integer id)
	{
		return userEmailTemplateRepository.findById(id).orElseThrow(()->new NoElementFoundException(id));
	}

	public UserEmailTemplate createEmailTemplate(UserEmailTemplate userEmailTemplate) {
		return userEmailTemplateRepository.save(userEmailTemplate);
	}

	public UserEmailTemplate updateUserEmailTemplate(UserEmailTemplate userEmailTemplate, Boolean create) throws NoElementFoundException{
		Optional<UserEmailTemplate> userEmailTemplateOptional = userEmailTemplateRepository.findById(userEmailTemplate.getId());
		if(userEmailTemplateOptional.isPresent())
		{
			UserEmailTemplate userEmailTemplateToSave = userEmailTemplateOptional.get();
			userEmailTemplateToSave.setId(userEmailTemplate.getId());
			return userEmailTemplateRepository.save(userEmailTemplateToSave);
		}
		else
		{
			if(create)
				return createEmailTemplate(userEmailTemplate);
			else
				throw new NoElementFoundException(userEmailTemplate.getId());
		}	
	}

	public void deleteUserEmailTemplate(Integer id) {
		userEmailTemplateRepository.deleteById(id);
	}

	public List<UserEmailTemplate> getEmailTemplateByIdUserAndAvailableRule(Integer userId, Integer availableRuleId)
	{
		return userEmailTemplateRepository.findByUserIdAndAvailableRuleId(userId, availableRuleId);
	}
}
