package com.mg.configurationManager.exceptions;

public class NoElementFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoElementFoundException(Integer id)
	{
		super(String.format("No Data Found with Id %d ", id));
	}
}
