
package com.app.connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class SingletonConnection {
	private static Connection connection;
	
	static {
	     try {
	    	    Class.forName("org.sqlite.JDBC");
	            String dbURL = "jdbc:sqlite:./database/ecole.sqlite";
	            connection = DriverManager.getConnection(dbURL);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	     
      }
public static Connection getConnection() {
	return (Connection) connection;
}
	

}
