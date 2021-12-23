package com.webshop.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public static Connection getJDBCConnection() {
		final String url = "jdbc:mysql://localhost:3306/product";
		final String user = "root";
		final String password = "tranbinhkha16092003";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// Check
	public static void main(String[] args) {
		Connection connection = JDBCConnection.getJDBCConnection();

		if (connection != null) {
			System.out.print("Thanh cong");
		} else {
			System.out.print("That bai");
		}
	}
}
