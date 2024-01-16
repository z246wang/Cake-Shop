package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;

/**
 * Servlet implementation class UserChangePwd
 */
@WebServlet("/user_changePwd")
public class UserChangePwdServlet extends HttpServlet {
	
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
		//receive password info.
		String password = request.getParameter("password");
		String newPwd = request.getParameter("newPassword");
		
		// Null/empty input check.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user_center.jsp");
		if(password == null || password.isEmpty() || newPwd == null || newPwd.isEmpty()) {
		request.setAttribute("failMsg", "Invalid input!");
		dispatcher.forward(request, response);
		return;
		}
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		if(u == null) {
		    response.sendRedirect("/login.jsp");
		    return;
		}
		
		//check password change successful or not.
		if(password.equals(u.getPassword())) {
			u.setPassword(newPwd);
			uService.updatePwd(u);
			request.setAttribute("msg", "Update Success!");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("failMsg", "Wrong Old Password!");
			dispatcher.forward(request, response);
		}
	}
}
