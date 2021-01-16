package com.app.exception;

public class NullAuthentificationDataException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullAuthentificationDataException ( ) {
	}
	
	public NullAuthentificationDataException ( String message ) {
	super( message );
	}

}
