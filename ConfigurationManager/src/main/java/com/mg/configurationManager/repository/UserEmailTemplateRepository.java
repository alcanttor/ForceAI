package com.mg.configurationManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mg.configurationManager.entity.UserEmailTemplate;

@Repository
public interface UserEmailTemplateRepository extends JpaRepository<UserEmailTemplate, Integer>{

	public List<UserEmailTemplate> findByUserIdAndAvailableRuleId(Integer userId,Integer AvailableRuleId);
}
