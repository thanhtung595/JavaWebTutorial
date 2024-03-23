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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class NguyenThanhTung_KHACHHANGCreateServlet
 */
@WebServlet("/khachHangCreate")
public class NguyenThanhTung_KHACHHANGCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NguyenThanhTung_KHACHHANGCreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/NguyenThanhTung/KHACHHANGCreate_NguyenThanhTung.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;

		// Lay du lieu tren from
		String MAKH_2110900048 = (String) request.getParameter("MAKH_2110900048");
		String HOTEN_2110900048 = (String) request.getParameter("HOTEN_2110900048");
		String NGAYSINH_2110900048STR = (String) request.getParameter("NGAYSINH_2110900048");
		String GIOITINH_2110900048STR = (String) request.getParameter("GIOITINH_2110900048");
		String ANH_2110900048 = (String) request.getParameter("ANH_2110900048");
		String TINHTRANG_2110900048STR = (String) request.getParameter("TINHTRANG_2110900048");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp NGAYSINH_2110900048 = null;
		try {
			java.util.Date parsedDate = dateFormat.parse(NGAYSINH_2110900048STR);
			NGAYSINH_2110900048 = new Timestamp(parsedDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Boolean GIOITINH_2110900048 = false;
		if (GIOITINH_2110900048STR.equalsIgnoreCase("true") || GIOITINH_2110900048STR.equals("1")) {
			GIOITINH_2110900048 = true;
		} else if (GIOITINH_2110900048STR.equalsIgnoreCase("false") || GIOITINH_2110900048STR.equals("0")) {
			GIOITINH_2110900048 = false;
		}

		Boolean TINHTRANG_2110900048 = false;
		if (TINHTRANG_2110900048STR.equalsIgnoreCase("true") || TINHTRANG_2110900048STR.equals("1")) {
			TINHTRANG_2110900048 = true;
		} else if (TINHTRANG_2110900048STR.equalsIgnoreCase("false") || TINHTRANG_2110900048STR.equals("0")) {
			TINHTRANG_2110900048 = false;
		}

		KHACHHANG_NguyenThanhTung kh = new KHACHHANG_NguyenThanhTung(MAKH_2110900048, HOTEN_2110900048,NGAYSINH_2110900048STR, GIOITINH_2110900048, ANH_2110900048, TINHTRANG_2110900048);
		
		String regex = "\\w+";
		if (MAKH_2110900048 == null || !MAKH_2110900048.matches(regex)) {
			errorString = "MAKH invalid!";
		}

		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("kh", kh);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/NguyenThanhTung/KHACHHANGCreate_NguyenThanhTung.jsp");

			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
		try {
			conn = NguyenThanhTungConnectionUtils.getMSSQLConnection();
			KHACHHANG_NguyenThanhTung_Utils.insertKhachHang(conn, kh);
			response.sendRedirect(request.getContextPath() + "/khachHangList");

		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/NguyenThanhTung/KHACHHANGCreate_NguyenThanhTung.jsp");
			dispatcher.forward(request, response);
		}
	}

}
