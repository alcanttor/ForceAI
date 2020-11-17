package com.mg.configurationManager.entityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.entity.Plan;
import com.mg.configurationManager.exceptions.NoElementFoundException;
import com.mg.configurationManager.repository.PlanRepository;

@Service
public class PlanEntityService {
	
	@Autowired
	private PlanRepository planRepository;
	
	public Plan getPlanById(Integer planId)
	{
		
			return planRepository.findById(planId).orElseThrow(()->new NoElementFoundException(planId));
	}
}
