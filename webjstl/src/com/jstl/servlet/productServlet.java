package com.jstl.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eight.entity.Product;
import com.jstl.jdbc.dao.IProductDao;
import com.jstl.jdbc.daoimpl.ProductDaoImpl;

public class productServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		IProductDao dao = new ProductDaoImpl();
		List<Product> product = dao.selectProductAll();
		/*for(Product p : product){	
			System.out.println(p.getName());
		}*/
		req.setAttribute("products", product);
		req.getRequestDispatcher("product.jsp").forward(req, resp);
		//resp.sendRedirect("product.jsp");
	}

}
