package thanhtung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import thanhtung.conn.ConnectionUtils;
import thanhtung.utils.ProductUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Servlet implementation class ProductDeleteServlet
 */
@WebServlet("/productDelete")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lay du lieu tren from
				String code = (String) request.getParameter("code");
				Connection conn = null;
		        String errorString = null;

		        try {
		            conn = ConnectionUtils.getMSSQLConnection();
		            ProductUtils.deleteProduct(conn, code);
		        } catch (ClassNotFoundException | SQLException  e) {
		            e.printStackTrace();
		            errorString = e.getMessage();
		        }

		        if (errorString != null) {
		            request.setAttribute("errorString", errorString);
		            RequestDispatcher dispatcher = request.getServletContext()
		                    .getRequestDispatcher("/WEB-INF/views/productDeleteError.jsp");
		            dispatcher.forward(request, response);
		        } else {
		            response.sendRedirect(request.getContextPath()+"/productList");
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
