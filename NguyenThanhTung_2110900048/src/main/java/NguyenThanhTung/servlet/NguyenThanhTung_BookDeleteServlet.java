package NguyenThanhTung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import NguyenThanhTung.conn.NguyenThanhTungConnection;
import NguyenThanhTung.utils.NguyenThanhTung_BookUtils;

/**
 * Servlet implementation class NguyenThanhTung_BookDeleteServlet
 */
@WebServlet("/bookDelete")
public class NguyenThanhTung_BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NguyenThanhTung_BookDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lay du lieu tren from
		String maSach = (String) request.getParameter("maSach");
		Connection conn = null;
        String errorString = null;

        try {
            conn = NguyenThanhTungConnection.getMSSQLConnection();
            NguyenThanhTung_BookUtils.deleteBook(conn, maSach);
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
