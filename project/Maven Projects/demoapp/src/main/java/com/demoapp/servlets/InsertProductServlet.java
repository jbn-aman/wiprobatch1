package com.demoapp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Servlet implementation class InsertProductServlet
 */
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int productId = Integer.parseInt(request.getParameter("pid"));
		String productName = request.getParameter("pname");
		double productPrice = Double.parseDouble(request.getParameter("pprice"));
		LocalDate mfd = LocalDate.parse(request.getParameter("pdate"));
		String category = request.getParameter("pcategory");

		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Insert Product</title></head><body>");

		out.println("<h2>");
		out.println("<br>ProductId: " + productId);
		out.println("<br>ProductName: " + productName);
		out.println("<br>Price: " + productPrice);
		out.println("<br>MFD: " + mfd);
		out.println("<br>ProductName: " + category);

		out.println("</h2>");

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "wipro";
		String password = "wipro123";
		Connection con = null;
		try {

			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("connected");

			String sql = "insert into product_tbl values(?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ps.setString(2, productName);
			ps.setDouble(3, productPrice);
			ps.setDate(4, Date.valueOf(mfd));
			ps.setString(5, category);

			int noOfRowsEffected = ps.executeUpdate();

			out.println("<h2>New Product is added</h2>");

		} catch (ClassNotFoundException e) {
			e.getStackTrace();
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			
			try {
					con.close();
					System.out.println("connection closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
