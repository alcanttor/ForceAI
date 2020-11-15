package com.mg.configurationManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mg.configurationManager.entity.AvailableRule;

@Repository
public interface AvailableRuleRepository extends JpaRepository<AvailableRule, Integer>{

}
