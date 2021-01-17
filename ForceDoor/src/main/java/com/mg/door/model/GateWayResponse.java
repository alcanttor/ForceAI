package com.mg.door.model;

import org.springframework.stereotype.Component;

@Component
public class GateWayResponse {

	private GateWayResult gateWayResult;

	public GateWayResult getGateWayResult() {
		return gateWayResult;
	}

	public void setGateWayResult(GateWayResult gateWayResult) {
		this.gateWayResult = gateWayResult;
	}
	
	
}
