package com.webshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webshop.JDBC.JDBCConnection;
import com.webshop.model.Category;
import com.webshop.model.Product;

public class HomeDao {
	Connection connection = JDBCConnection.getJDBCConnection();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	private static final String SELECT_ALL_PRODUCTS = "select * from product;";
	private static final String SELECT_ALL_CATEGORIES = "select * from category;";
	private static final String SELECT_LAST_PRODUCT = "select * from product.product\r\n" + "order by id desc\r\n"
			+ "limit 1;";
	private static final String SELECT_PRODUCT_BY_CID = "select * from product.product\r\n" + "where cateID = ?;";
	private static final String SELECT_PRODUCT_BY_ID = "select * from product.product\r\n" + "where id = ?;";

	// Get all products
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String image = resultSet.getString("image");
				String description = resultSet.getString("description");
				double price = resultSet.getDouble("price");
				int cateID = resultSet.getInt("cateID");
				String title = resultSet.getString("title");
				int sellID = resultSet.getInt("sell_ID");
				int views = resultSet.getInt("views");
				list.add(new Product(id, name, image, description, price, cateID, title, sellID, views));
			}
		} catch (Exception e) {
		}

		return list;
	}

	// Get all categories
	public List<Category> getAllCategories() {
		List<Category> list = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				list.add(new Category(resultSet.getInt(1), resultSet.getString(2)));
			}
		} catch (Exception e) {
		}

		return list;
	}

	// get newest product
	public Product getLast() {

		try {
			preparedStatement = connection.prepareStatement(SELECT_LAST_PRODUCT);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String image = resultSet.getString("image");
				String description = resultSet.getString("description");
				double price = resultSet.getDouble("price");
				int cateID = resultSet.getInt("cateID");
				String title = resultSet.getString("title");
				int sellID = resultSet.getInt("sell_ID");
				int views = resultSet.getInt("views");
				return new Product(name, image, description, price, cateID, title, sellID, views);
			}

		} catch (Exception e) {
		}
		return null;
	}

	// get product by category id
	public List<Product> getProductByCID(String cid) {
		List<Product> list = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_CID);
			preparedStatement.setString(1, cid);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String image = resultSet.getString("image");
				String description = resultSet.getString("description");
				double price = resultSet.getDouble("price");
				int cateID = resultSet.getInt("cateID");
				String title = resultSet.getString("title");
				int sellID = resultSet.getInt("sell_ID");
				int views = resultSet.getInt("views");
				list.add(new Product(id, name, image, description, price, cateID, title, sellID, views));
			}
		} catch (Exception e) {
		}

		return list;
	}

	// get product by id
	public Product getProductByID(String id) {

		try {
			preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String image = resultSet.getString("image");
				String description = resultSet.getString("description");
				double price = resultSet.getDouble("price");
				int cateID = resultSet.getInt("cateID");
				String title = resultSet.getString("title");
				int sellID = resultSet.getInt("sell_ID");
				int views = resultSet.getInt("views");
				return new Product(name, image, description, price, cateID, title, sellID, views);
			}

		} catch (Exception e) {
		}
		return null;
	}

	// main test
	public static void main(String[] args) {
		HomeDao dao = new HomeDao();
		Product list = dao.getProductByID("4");

		System.out.println(list.getPrice());

	}
}
