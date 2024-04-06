package com.demoapp.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.demoapp.dao.ProductDao;
import com.demoapp.dto.Product;

/**
 * Servlet implementation class FetchAllProducts
 */
public class FetchAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.findAllProducts();
		
		RequestDispatcher rd = request.getRequestDispatcher("displayallproduct.jsp");
		request.setAttribute("mylist", products);
		rd.forward(request, response);
		
	
}
}
