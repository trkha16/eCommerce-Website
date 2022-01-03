package com.webshop.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshop.DAO.AccountDao;
import com.webshop.DAO.HomeDao;
import com.webshop.model.Account;

/**
 * Servlet implementation class RegisterControl
 */
@WebServlet("/register")
public class RegisterControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterControl() {
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

		AccountDao accountDao = new AccountDao();

		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String rePass = request.getParameter("repass");
		String name = request.getParameter("name");

		AccountDao dao = new AccountDao();
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		account.setName(name);

		//System.out.println(dao.checkLogin(account).getUsername());

		try {
			if (password.equals(rePass)) {
				accountDao.register(account);
				response.sendRedirect("Login.jsp");
			} else {
				response.sendRedirect("Register.jsp");
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
