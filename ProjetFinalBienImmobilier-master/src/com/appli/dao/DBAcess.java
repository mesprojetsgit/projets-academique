package com.appli.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton pattern
public class DBAcess {
	private static Connection connection = null;

	private DBAcess () throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost/dbetudiants?serverTimezone=UTC", "root", "");
	}

	public static Connection getInstance () throws SQLException {
		if (connection == null) {
			new DBAcess ();
		}

		return connection;
	}
}
