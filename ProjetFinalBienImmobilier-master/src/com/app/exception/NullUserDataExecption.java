package com.app.exception;

import java.sql.SQLException;

public class NullUserDataExecption extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param reason
	 */
	public NullUserDataExecption(String reason) {
		super(reason);
		// TODO Auto-generated constructor stub
	}

	
}
