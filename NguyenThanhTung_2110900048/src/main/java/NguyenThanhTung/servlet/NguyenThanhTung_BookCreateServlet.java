package NguyenThanhTung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

import NguyenThanhTung.beans.NguyenThanhTung_2110900048_Book;
import NguyenThanhTung.conn.NguyenThanhTungConnection;
import NguyenThanhTung.utils.NguyenThanhTung_BookUtils;

/**
 * Servlet implementation class NguyenThanhTung_BookCreateServlet
 */
@WebServlet("/bookCreate")
public class NguyenThanhTung_BookCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NguyenThanhTung_BookCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher  = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/nguyenthanhtung_BookCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		
		//Lay du lieu tren from
		String maSach = (String) request.getParameter("maSach");
		String tenSach = (String) request.getParameter("tenSach");
		String soLuongStr = (String) request.getParameter("soLuong");
		String donGiaStr = (String) request.getParameter("donGia");
		String anh = (String) request.getParameter("anh");
		int soLuong = 0;
		try {
			soLuong = Integer.parseInt(soLuongStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		float donGia = 0;
		try {
			donGia = Float.parseFloat(donGiaStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		NguyenThanhTung_2110900048_Book book = new NguyenThanhTung_2110900048_Book(maSach,tenSach,soLuong,donGia,anh);
		//Kiem tra code it nhat 1 ky tu
		String regex = "\\w+";
		if(maSach == null || !maSach.matches(regex)) {
			errorString = "Product code invalid!";
		}
		
		if(errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("book", book);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/nguyenthanhtung_BookCreate.jsp");
			
			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
		try {
			conn = NguyenThanhTungConnection.getMSSQLConnection();
			NguyenThanhTung_BookUtils.insertBook(conn, book);
			response.sendRedirect(request.getContextPath()+"/bookList");
			
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/nguyenthanhtung_BookCreate.jsp");
			dispatcher.forward(request, response);
		}
	}

}
