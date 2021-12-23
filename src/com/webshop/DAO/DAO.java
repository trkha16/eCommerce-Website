package com.webshop.DAO;

import java.sql.Connection;

import com.webshop.JDBC.JDBCConnection;

public class DAO {
	Connection connection = JDBCConnection.getJDBCConnection();
	
	private static final String SELECT_ALL_PRODUCTS = "select * from product";
}
