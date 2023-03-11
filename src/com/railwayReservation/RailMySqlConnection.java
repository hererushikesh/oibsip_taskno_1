package com.railwayReservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RailMySqlConnection {
	
	private static final String SQL_INSERT = "INSERT INTO registration"
			+ "(fname, lname, emailId, password, age,phone) VALUES (?,?,?,?,?,?)";

	private static final String SQL_SELECT = "SELECT * From registration";
	
	public static void insertDataIntoRegistrationTable(String fname, String lname, 
			String emailId, String password,int age, long phone) {
		try {
			Connection conn = MySQLConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT);

			preparedStatement.setString(1, fname);
			preparedStatement.setString(2, lname);
			preparedStatement.setString(3, emailId);
			preparedStatement.setString(4, password);
			preparedStatement.setInt(5, age);
			preparedStatement.setLong(6, phone);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("exception occurred" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static boolean isUserPresent(String userEnteredemail, String userEnteredpassword) {
		try {
			Connection conn = MySQLConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
			ResultSet resultSet = preparedStatement.executeQuery();
			// executeQuery -? select
			// executeUpdate -? insert, update , delete
			while (resultSet.next()) {
				String email = resultSet.getString(4);
				String password = resultSet.getString(5);
				if (email.equals(userEnteredemail) && password.equals(userEnteredpassword)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
