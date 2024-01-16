package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/user_login")
public class UserLoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService uService;

	@Override
	public void init() throws ServletException {
		uService = new UserService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//receive account info.
		String ue = request.getParameter("ue");
		String password = request.getParameter("password");
		User user = uService.login(ue, password);
		
		//check log in success or not.
		if(user==null) {
			request.setAttribute("failMsg", "Wrong Entry!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/user_login.jsp");
			dispatcher.forward(request, response);
		}else {
			request.getSession().setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/user_center.jsp");
			dispatcher.forward(request, response);
		}
	}
}
