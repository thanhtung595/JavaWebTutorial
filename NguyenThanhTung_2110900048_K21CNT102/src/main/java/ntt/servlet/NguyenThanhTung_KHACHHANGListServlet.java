package ntt.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ntt.beans.KHACHHANG_NguyenThanhTung;
import ntt.conn.NguyenThanhTungConnectionUtils;
import ntt.utils.KHACHHANG_NguyenThanhTung_Utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class NguyenThanhTung_KHACHHANGListServlet
 */
@WebServlet("/khachHangList")
public class NguyenThanhTung_KHACHHANGListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NguyenThanhTung_KHACHHANGListServlet() {
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
		List<KHACHHANG_NguyenThanhTung> list = null;
		try {
			conn = NguyenThanhTungConnectionUtils.getMSSQLConnection();
			try {
				list = KHACHHANG_NguyenThanhTung_Utils.getAllKhachHang(conn);
			} catch (Exception e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
			
			request.setAttribute("errorString", errorString);
			for (KHACHHANG_NguyenThanhTung kh : list) {
				successString = kh.getMAKH_2110900048();
			}
			request.setAttribute("successString", successString);
			request.setAttribute("khachHangList", list);
			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/NguyenThanhTung/KHACHHANGList_NguyenThanhTung.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException| SQLException e1) {
			e1.printStackTrace();
			errorString = e1.getMessage();
			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/NguyenThanhTung/KHACHHANGList_NguyenThanhTung.jsp");
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
