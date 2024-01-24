package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import connect.ConnectionUtils;
import untils.ProductUtils;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet{
	private static final long serialVersionUID = 1;
	public ProductListServlet() {
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
		throws ServletException, IOException{
		
		Connection conn = null;
		String errorString = null;
		String successString = "Ok roi";
		List<Product> list = null;
		try {
			conn = ConnectionUtils.getMySQLConnection();
			try {
				list = ProductUtils.queryProduct(conn);
			} catch (Exception e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
			
			request.setAttribute("errorString", errorString);
			for (Product product : list) {
				successString = product.getName();
			}
			request.setAttribute("successString", successString);
			request.setAttribute("productList", list);
			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/productList.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException| SQLException e1) {
			e1.printStackTrace();
			errorString = e1.getMessage();
			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/productList.jsp");
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
		throws ServletException, IOException{
		
		doGet(request, response);
	}
}
