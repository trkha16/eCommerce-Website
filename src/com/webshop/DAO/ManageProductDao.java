package com.webshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webshop.JDBC.JDBCConnection;
import com.webshop.model.Product;

public class ManageProductDao {

	Connection connection = JDBCConnection.getJDBCConnection();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	// Delete Product By Id
	public void deleteProductByID(String id) {
		String query = "delete from product.product\r\n" + "where id = ?;";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// get product by sell_id
	public List<Product> getProductBySellID(int sellId) {
		List<Product> list = new ArrayList<>();
		String query = "select * from product.product\r\n" + "where sell_id = ?;";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, sellId);
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

	// Add product into sellID
	public void addProduct(String name, String image, double price, String title, String description, int cateID,
			int sell_ID) {
		String query = "insert into product.product (name, image, price, title, description, cateID, sell_ID)\r\n"
				+ "values (?,?,?,?,?,?,?);";
		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, image);
			preparedStatement.setDouble(3, price);
			preparedStatement.setString(4, title);
			preparedStatement.setString(5, description);
			preparedStatement.setInt(6, cateID);
			preparedStatement.setInt(7, sell_ID);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// Edit product by id
	public void editProductByID(String name, String image, double price, String title, String description, int cateID,
			String id) {
		String query = "UPDATE product.product\r\n"
				+ "SET name = ?, image = ?, price = ?, title = ?, description = ?, cateID = ? \r\n" + "WHERE id = ?;";
		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, image);
			preparedStatement.setDouble(3, price);
			preparedStatement.setString(4, title);
			preparedStatement.setString(5, description);
			preparedStatement.setInt(6, cateID);
			preparedStatement.setString(7, id);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		ManageProductDao dao = new ManageProductDao();

		// dao.editProductByID("2", "2", 111, "!", "2", 2, 2);

	}
}
