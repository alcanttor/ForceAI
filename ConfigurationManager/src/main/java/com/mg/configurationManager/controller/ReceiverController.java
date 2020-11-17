package com.mg.configurationManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mg.configurationManager.Service.impl.RuleEngine;
import com.mg.configurationManager.model.GateWayResponse;
import com.mg.configurationManager.model.GateWayResult;
import com.mg.configurationManager.model.HoaderData;

@RestController
public class ReceiverController {

	@Autowired
	private RuleEngine ruleEngine;

	@PostMapping("/gateway")
	public GateWayResponse input(@RequestBody HoaderData hoaderData) {
		GateWayResponse gateWayResponse = new GateWayResponse();
		try {
			ruleEngine.processEvent(hoaderData);

			gateWayResponse.setGateWayResult(GateWayResult.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			gateWayResponse.setGateWayResult(GateWayResult.REJECTED);
		}

		return gateWayResponse;
		// RuleSolver
	}

}
