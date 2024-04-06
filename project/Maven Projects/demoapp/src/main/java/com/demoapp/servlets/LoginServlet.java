package com.demoapp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String pwd = request.getParameter("upwd");

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Login</title></head><body>");

		if (pwd.equals("1234")) {
			out.println("<h2>Welcome "+ uname + "</h2>");
		} else {
			out.println("<h2>Invalid Password");
		}
		
		out.println("</body></html>");
		out.close();

	}
}
