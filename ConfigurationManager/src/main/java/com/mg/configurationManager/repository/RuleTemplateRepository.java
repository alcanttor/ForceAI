package com.mg.configurationManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mg.configurationManager.entity.FixRule;

@Repository
public interface RuleTemplateRepository extends JpaRepository<FixRule, Integer>{

}
