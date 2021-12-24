package com.webshop.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.stylesheets.LinkStyle;

import com.webshop.DAO.HomeDao;
import com.webshop.model.Category;
import com.webshop.model.Product;

import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class CategoryControl
 */
@WebServlet("/category")
public class CategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryControl() {
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
		String cid = request.getParameter("cid");
		List<Product> getProductByCID = dao.getProductByCID(cid);
		List<Category> listC = dao.getAllCategories();
		Product last = dao.getLast();

		request.setAttribute("listP", getProductByCID);
		request.setAttribute("listC", listC);
		request.setAttribute("p", last);
		request.setAttribute("tag", cid);
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
