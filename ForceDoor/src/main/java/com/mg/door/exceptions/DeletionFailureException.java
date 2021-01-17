package com.mg.door.exceptions;

public class DeletionFailureException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeletionFailureException(Integer id)
	{
		super(String.format("No Data deleted with Id %d ", id));
	}
}
