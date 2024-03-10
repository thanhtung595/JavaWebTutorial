package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.BookUtils;
import utils.CategoryUtils;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import beans.Book;
import beans.Category;
import conn.NguyenThanhTungConnection;

/**
 * Servlet implementation class BookCreateServlet
 */
@WebServlet("/bookCreate")
public class BookCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookCreateServlet() {
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
		List<Category> list = null;
		try {
			conn = NguyenThanhTungConnection.getMSSQLConnection();
			try {
				list = CategoryUtils.queryCategory(conn);
			} catch (Exception e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
			
			request.setAttribute("errorString", errorString);
			for (Category category : list) {
				successString = category.getCategoryName();
			}
			request.setAttribute("successString", successString);
			request.setAttribute("categoryList", list);
			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/nguyenthanhtung_BookCreate.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher dispatcher  = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/nguyenthanhtung_BookCreate.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		
		//Lay du lieu tren from
		String bookId = (String) request.getParameter("bookId");
		String title = (String) request.getParameter("title");
		String author = (String) request.getParameter("author");
		String releaseStr = (String) request.getParameter("release");
		String priceStr = (String) request.getParameter("price");
		String picture = (String) request.getParameter("picture");
		String publisherIdStr = (String) request.getParameter("publisherId");
		String categoryIdStr = (String) request.getParameter("categoryId");
		
		int release = 0;
		float price = 0;
		int publisherId = 0;
		int categoryId = 0;
		try {
			release = Integer.parseInt(releaseStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		try {
			price = Float.parseFloat(priceStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		try {
			publisherId = Integer.parseInt(publisherIdStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		try {
			categoryId = Integer.parseInt(categoryIdStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		Book book = new Book(bookId,title,author,release,price,picture,publisherId,categoryId);
		//Kiem tra code it nhat 1 ky tu
		String regex = "\\w+";
		if(bookId == null || !bookId.matches(regex)) {
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
			BookUtils.insertBook(conn, book);
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
