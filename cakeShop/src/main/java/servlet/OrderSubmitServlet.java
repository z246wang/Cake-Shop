package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OrderSubmitServlet
 */
@WebServlet("/order_submit")
public class OrderSubmitServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if(session.getAttribute("user")!= null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/order_submit.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("failMsg", "Please Log in First!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/user_login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
