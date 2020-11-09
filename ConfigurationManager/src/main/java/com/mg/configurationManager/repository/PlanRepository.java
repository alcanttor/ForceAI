package com.mg.configurationManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mg.configurationManager.entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer>{

}
