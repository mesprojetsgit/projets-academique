package com.app.exception;

import java.sql.SQLException;

public class NullLocataireDataExeption extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param reason
	 */
	public NullLocataireDataExeption(String reason) {
		super(reason);
		// TODO Auto-generated constructor stub
	}

}
