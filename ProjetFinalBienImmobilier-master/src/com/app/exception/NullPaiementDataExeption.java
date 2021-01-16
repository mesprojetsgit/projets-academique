package com.app.exception;

import java.sql.SQLException;

public class NullPaiementDataExeption extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param reason
	 */
	public NullPaiementDataExeption(String reason) {
		super(reason);
		// TODO Auto-generated constructor stub
	}

}
