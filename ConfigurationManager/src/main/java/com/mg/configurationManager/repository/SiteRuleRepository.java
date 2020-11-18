package com.mg.configurationManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mg.configurationManager.entity.Event;
import com.mg.configurationManager.entity.SiteRule;

public interface SiteRuleRepository extends JpaRepository<SiteRule, Integer>{

	public List<SiteRule> findBySiteId(Integer siteId);

	public List<SiteRule> findBySiteIdAndEvent(Integer siteId, Event event);
}
