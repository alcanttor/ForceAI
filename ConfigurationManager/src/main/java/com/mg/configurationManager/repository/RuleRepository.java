package com.mg.configurationManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mg.configurationManager.entity.Rule;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Integer>{

}
