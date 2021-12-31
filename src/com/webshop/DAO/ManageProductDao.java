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

	// get product by  sell_id
	public List<Product> getProductBySellID(int sellId) {
		List<Product> list = new ArrayList<>();
		String query = "select * from product.product\r\n" + 
				"where sell_id = ?;";

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
	
	public static void main(String[] args) {
		ManageProductDao dao = new ManageProductDao();
		List<Product> list = dao.getProductBySellID(1);
		for(Product o : list) {
			System.out.println(o.getName());
		}
	}

}
