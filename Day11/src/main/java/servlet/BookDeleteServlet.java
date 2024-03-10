package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.BookUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import conn.NguyenThanhTungConnection;

/**
 * Servlet implementation class BookDeleteServlet
 */
@WebServlet("/bookDelete")
public class BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lay du lieu tren from
				String bookId = (String) request.getParameter("bookId");
				Connection conn = null;
		        String errorString = null;

		        try {
		            conn = NguyenThanhTungConnection.getMSSQLConnection();
		            BookUtils.deleteBook(conn, bookId);
		        } catch (ClassNotFoundException | SQLException  e) {
		            e.printStackTrace();
		            errorString = e.getMessage();
		        }

		        if (errorString != null) {
		        } else {
		            response.sendRedirect(request.getContextPath()+"/bookList");
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
