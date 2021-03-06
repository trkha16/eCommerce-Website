package com.webshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;

import com.webshop.JDBC.JDBCConnection;
import com.webshop.model.Account;

public class AccountDao {
	Connection connection = JDBCConnection.getJDBCConnection();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	private static final String CHECK_LOGIN = "select * from product.account\r\n"
			+ "where username = ? and password = ?;";
	private static final String INSERT_USERS_SQL = "INSERT INTO product.account (username, password, name) VALUES (?,?,?);";

	public Account checkLogin(Account account) {
		// boolean status = false;

		try {
			preparedStatement = connection.prepareStatement(CHECK_LOGIN);
			preparedStatement.setString(1, account.getUsername());
			preparedStatement.setString(2, account.getPassword());

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				int isSell = resultSet.getInt("isSell");
				int isAdmin = resultSet.getInt("isAdmin");
				String name = resultSet.getString("name");

				return new Account(id, username, password, name, isSell, isAdmin);
			}
		} catch (Exception e) {
		}

		return null;
	}

	public int register(Account account) {
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, account.getUsername());
			preparedStatement.setString(2, account.getPassword());
			preparedStatement.setString(3, account.getName());

			result = preparedStatement.executeUpdate();

		} catch (Exception e) {
		}

		return result;
	}

	public boolean checkExistUsername(String username) {
		String query = "select *\r\n" + "from product.account\r\n" + "where username = ?;";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
