package com.mg.door.model;

import org.springframework.stereotype.Component;

@Component
public class ActionDto {

	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ActionDto [id=" + id + ", name=" + name + "]";
	}
	
	
}
