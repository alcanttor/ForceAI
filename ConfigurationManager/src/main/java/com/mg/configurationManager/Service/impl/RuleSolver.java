package com.mg.configurationManager.Service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mg.configurationManager.entity.DataType;
import com.mg.configurationManager.model.HoaderData;
import com.mg.configurationManager.model.RuleDto;

@Service
public class RuleSolver {

	public Boolean solve(List<RuleDto> rules, HoaderData hoaderData)
	{
		for (RuleDto ruleDto : rules) {
			if(!solve(ruleDto,hoaderData))
				return false;
		}
		return true;
	}
	
	public Boolean solve(RuleDto rule, HoaderData hoaderData)
	{
		System.out.println("rule : "+rule);
		System.out.println("data : "+hoaderData);
		System.out.println("compare ["+rule.getMin()+"] to ["+hoaderData.getDataMap().get(rule.getSystemParameterDto().getName())+"]");
		switch (rule.getOperation()) {
		case EQUAL:
			if (rule.getSystemParameterDto().getDataType() == DataType.STRING)
			{
				return (rule.getMin().equals(hoaderData.getDataMap().get(rule.getSystemParameterDto().getName())));
			}
			else
			{
				return (rule.getMin() == (hoaderData.getDataMap().get(rule.getSystemParameterDto().getName())));
			}
		default:
			return false;
		}
	}
	
	/*public static void main(String ss[])
	{
		HoaderData hoaderData = new HoaderData();
		Map<String , String> data = new HashMap<String, String>();
		data.put("previousRole","customer");
		data.put("newRole","admin");
		hoaderData.setDataMap(data);
		hoaderData.setEvent(Event.ROLE_CHANGE);
		//System.out.println("data set : "+hoaderData);
		//get all rules of event - select * from site_rule
		Rule rule = new Rule();
		SystemParameters parameter = new SystemParameters();
		parameter.setName("newRole");
		rule.setParameter(parameter);
		rule.setOperation(Operation.EQUAL);
		rule.setMin("admin");
		solve(rule,hoaderData);
	}*/
}
