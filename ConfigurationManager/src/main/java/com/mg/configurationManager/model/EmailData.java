package com.mg.configurationManager.model;

import org.springframework.stereotype.Component;

@Component
public class EmailData {

	private String to;
	private String subject;
	private String text;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "EmailData [to=" + to + ", subject=" + subject + ", text=" + text + "]";
	}
	
	
}
