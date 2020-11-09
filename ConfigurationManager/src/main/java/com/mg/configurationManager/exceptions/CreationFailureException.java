package com.mg.configurationManager.exceptions;

public class CreationFailureException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreationFailureException(Integer id)
	{
		super(String.format("Unable to create record with Id %d ", id));
	}
	public CreationFailureException(String name)
	{
		super(String.format("Unable to create record with name %d ", name));
	}
}
