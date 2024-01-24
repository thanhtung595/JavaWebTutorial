package servlet;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1;
	public HomeServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
		throws ServletException, IOException{
		
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/homeView.jsp");
		
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
		throws ServletException, IOException{
		
		doGet(request, response);
	}
}
