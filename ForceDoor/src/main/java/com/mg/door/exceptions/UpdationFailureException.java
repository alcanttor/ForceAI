package com.mg.door.exceptions;

public class UpdationFailureException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpdationFailureException(Integer id)
	{
		super(String.format("No Data Record updated with Id %d ", id));
	}
}
