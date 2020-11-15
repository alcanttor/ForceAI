package com.mg.configurationManager.exceptions;

public class InCompleteInformation extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InCompleteInformation(String msg)
	{
		super(String.format(msg));
	}
}
