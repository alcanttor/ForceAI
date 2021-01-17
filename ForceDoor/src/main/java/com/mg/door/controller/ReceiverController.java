package com.mg.door.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mg.door.Service.impl.RuleEngine;
import com.mg.door.model.GateWayResponse;
import com.mg.door.model.GateWayResult;
import com.mg.door.model.HoaderData;

@RestController
public class ReceiverController {

	@Autowired
	private RuleEngine ruleEngine;

	@PostMapping("/gateway")
	public GateWayResponse input(@RequestBody HoaderData hoaderData) {
		GateWayResponse gateWayResponse = new GateWayResponse();
		try {
			System.out.println("received dataa..............."+hoaderData);
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
