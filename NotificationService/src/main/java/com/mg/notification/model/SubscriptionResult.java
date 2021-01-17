package com.mg.notification.model;

import org.springframework.stereotype.Component;

@Component
public class SubscriptionResult {

	ResultCode resultCode;
	String message;
	Object data;
	public ResultCode getResultCode() {
		return resultCode;
	}
	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
