package com.mg.door.exceptions;

public class NotImplementedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotImplementedException()
	{
		super(String.format("This functionaity is not available"));
	}
}
