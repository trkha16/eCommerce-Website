package com.webshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.webshop.JDBC.JDBCConnection;
import com.webshop.model.Account;

public class AccountDao {
	Connection connection = JDBCConnection.getJDBCConnection();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	private static final String CHECK_LOGIN = "select * from product.account\r\n"
			+ "where username = ? and password = ?;";

	public boolean checkLogin(Account account) {
		boolean status = false;

		try {
			preparedStatement = connection.prepareStatement(CHECK_LOGIN);
			preparedStatement.setString(1, account.getUsername());
			preparedStatement.setString(2, account.getPassword());

			resultSet = preparedStatement.executeQuery();

			status = resultSet.next();
		} catch (Exception e) {
		}

		return status;
	}
}
