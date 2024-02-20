package thanhtung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import thanhtung.beans.Product;
import thanhtung.conn.ConnectionUtils;
import thanhtung.utils.ProductUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		String errorString = null;
		String successString = "Ok roi";
		List<Product> list = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
