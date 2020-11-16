package com.mg.configurationManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mg.configurationManager.entity.AvailableRule;
import com.mg.configurationManager.entity.Connector;

@Repository
public interface AvailableRuleRepository extends JpaRepository<AvailableRule, Integer>{

	public List<AvailableRule> findByConnector(Connector connector);
}
