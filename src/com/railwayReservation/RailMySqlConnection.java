package com.railwayReservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RailMySqlConnection {

	private static String DB_URL = "jdbc:mysql://localhost/rail";
	private static String USER = "root";
	private static String PASS = "admin";
	private static final String SQL_INSERT = "INSERT INTO registration"
			+ "(fname, lname, emailId, password, age,phone) VALUES (?,?,?,?,?,?)";
	
	private static final String SQL_SELECT = "SELECT * From registration";
	
	private static final String SQL_SELECT_WITH_WHERE = "SELECT Count(*) From registration where emailId=? and password=?";
	


	public static void insertDataIntoRegistrationTable(String fname, String lname, 
			String emailId, String password,int age,long phone) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT);

			preparedStatement.setString(1, fname);
			preparedStatement.setString(2, lname);
			preparedStatement.setString(3, emailId);
			preparedStatement.setString(4, password);
			preparedStatement.setInt(5, age);
			preparedStatement.setLong(6, phone);    
			int row = preparedStatement.executeUpdate();
			System.out.println(row); // 1
			System.out.println("record inserted");

		} catch (SQLException e) {
			System.out.println("exception occirred" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static boolean isUserPresent(String userEnteredemail, String userEnteredpassword) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			// executeQuery -? select
			// executeUpdate -? insert, update , delete
			while(resultSet.next()) {
				
				int id = resultSet.getInt(1);
				String fname =resultSet.getString(2);
				String lname =resultSet.getString(3);
				String email =resultSet.getString(4);
				String password =resultSet.getString(5);
				int age=resultSet.getInt(6);
				long phone=resultSet.getLong(7);
				
				if(email.equals(userEnteredemail) && password.equals(userEnteredpassword)) {
					return true;
				}
				
				System.out.println(id+" "+ fname +" "+ lname+" "+email+" "+password+" "+age+" "+phone);
			}	
		} catch (SQLException e) {
			System.out.println("exception occirred" + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean isUserPresentUsingWhereQuery(String userEnteredemail, String userEnteredpassword) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_WITH_WHERE);	
			preparedStatement.setString(1, userEnteredemail);
			preparedStatement.setString(2, userEnteredpassword);			

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.first()) {
				return true;
			}			
		} catch (SQLException e) {
			//System.out.println("exception occirred" + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
}
