package com.app.exception;

import java.sql.SQLException;

public class NullIdDataExeption extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param reason
	 */
	public NullIdDataExeption(String reason) {
		super(reason);
		// TODO Auto-generated constructor stub
	}

}
