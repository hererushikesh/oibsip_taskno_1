package com.railwayReservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	
	private static String DB_URL = "jdbc:mysql://localhost/rail";
	private static String USER = "root";
	private static String PASS = "admin";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return con;
	}
}
