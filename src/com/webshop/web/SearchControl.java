package com.webshop.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshop.DAO.HomeDao;
import com.webshop.JDBC.JDBCConnection;
import com.webshop.model.Category;
import com.webshop.model.Product;

/**
 * Servlet implementation class SearchControl
 */
@WebServlet("/search")
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8"); // Search tieng viet

		HomeDao dao = new HomeDao();
		String txt = request.getParameter("txt");
		List<Product> list = dao.searchProducts(txt);
		List<Category> listC = dao.getAllCategories();
		Product last = dao.getLast();

		request.setAttribute("listP", list);
		request.setAttribute("listC", listC);
		request.setAttribute("p", last);
		request.setAttribute("txtValue", txt);

		RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
