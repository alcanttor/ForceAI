package com.mg.door.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mg.door.entity.Event;

@Component
@Scope("prototype")
public class HoaderData 
{
	@Autowired
	private Map<String, String> dataMap;
	private Event event;
	private String SiteToken;

	public Map<String, String> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, String> dataMap) {
		this.dataMap = dataMap;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	public String getSiteToken() {
		return SiteToken;
	}

	public void setSiteToken(String siteToken) {
		SiteToken = siteToken;
	}

	@Override
	public String toString() {
		return "HoaderData [dataMap=" + dataMap + ", event=" + event + "siteToken=" + SiteToken+"]";
	}
	
	
	
}
