package com.webshop.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshop.DAO.HomeDao;
import com.webshop.DAO.ManageProductDao;
import com.webshop.model.Category;
import com.webshop.model.Product;

/**
 * Servlet implementation class EditProductControl
 */
@WebServlet("/editproduct")
public class EditProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProductControl() {
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
		request.setCharacterEncoding("UTF-8");

		String id = (request.getParameter("id"));
		String name = request.getParameter("name");
		String image = request.getParameter("image");
		double price = Double.parseDouble(request.getParameter("price"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int cateID = Integer.parseInt(request.getParameter("category"));

		ManageProductDao dao = new ManageProductDao();
		dao.editProductByID(name, image, price, title, description, cateID, id);

		response.sendRedirect(request.getContextPath() + "/managerproduct");

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
