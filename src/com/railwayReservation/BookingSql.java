package com.railwayReservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class BookingSql {

	private static String DB_URL = "jdbc:mysql://localhost/rail";
	private static String USER = "root";
	private static String PASS = "admin";
	private static final String SQL_INSERT = "INSERT INTO booking_details (trainNo,fromAddress,toAddress,date,amount,name,address, email,age,gender,pnr) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	public static void insertDataIntoBookingTable(int trainNo, String from, String to, String date, int amount,
			String name, String address, String email, int age, String gender) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT);

			preparedStatement.setInt(1, trainNo);
			preparedStatement.setString(2, from);
			preparedStatement.setString(3, to);
			preparedStatement.setString(4, date);
			preparedStatement.setInt(5, amount);
			preparedStatement.setString(6, name);
			preparedStatement.setString(7, address);
			preparedStatement.setString(8, email);
			preparedStatement.setInt(9, age);
			preparedStatement.setString(10, gender);
		
			
			
			Random random=new Random();
			int max = Integer.MAX_VALUE;
			int min = 1000000000;

			int pnr = random.nextInt(max - min + 1) + min;
			
			preparedStatement.setString(11, String.valueOf(pnr));

		

			int row = preparedStatement.executeUpdate();
			System.out.println(row); // 1
			System.out.println("record inserted");

		} catch (SQLException e) {
			System.out.println("exception occirred" + e.getMessage());
			e.printStackTrace();
		}
	}

}
