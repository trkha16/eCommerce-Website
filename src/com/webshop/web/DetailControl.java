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
import com.webshop.model.Category;
import com.webshop.model.Product;

/**
 * Servlet implementation class DetailControl
 */
@WebServlet("/detail")
public class DetailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailControl() {
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

		HomeDao dao = new HomeDao();
		String id = request.getParameter("id");
		Product product = dao.getProductByID(id);
		List<Category> listC = dao.getAllCategories();
		Product last = dao.getLast();

		request.setAttribute("detail", product);
		request.setAttribute("listC", listC);
		request.setAttribute("p", last);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Detail.jsp");
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
