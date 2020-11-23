package com.mg.configurationManager.model;

import org.springframework.stereotype.Component;

import com.mg.configurationManager.entity.DataType;

@Component
public class SystemParametersDto {

	private Integer id;
	private String name;
	private DataType dataType;

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

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
}
