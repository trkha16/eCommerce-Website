package com.webshop.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webshop.DAO.AccountDao;
import com.webshop.model.Account;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginControl() {
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

		AccountDao accountDao = new AccountDao();
		Account account = new Account();
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		account.setUsername(username);
		account.setPassword(password);

		try {
			if (accountDao.checkLogin(account) != null) { // Login thanh cong
				HttpSession session = request.getSession();
				session.setAttribute("acc", accountDao.checkLogin(account));
				session.setAttribute("loginfail", 0);

				response.sendRedirect(request.getContextPath() + "/home");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("loginfail", 1);

				response.sendRedirect("Login.jsp");
			}

		} catch (Exception e) {

		}
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
