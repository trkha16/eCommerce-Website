package com.webshop.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webshop.DAO.ManageProductDao;
import com.webshop.model.Account;
import com.webshop.model.Product;

/**
 * Servlet implementation class ManageProductControl
 */
@WebServlet("/managerproduct")
public class ManageProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageProductControl() {
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

		ManageProductDao dao = new ManageProductDao();
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("acc");
		List<Product> list = dao.getProductBySellID(account.getId());

		System.out.println(account.getId());

		request.setAttribute("listP", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ManagerProduct.jsp");
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
