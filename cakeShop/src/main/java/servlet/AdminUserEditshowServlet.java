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
 * Servlet implementation class AdminUserEditshowServlet
 */
@WebServlet("/admin/user_editshow")
public class AdminUserEditshowServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService uService;

    @Override
    public void init() throws ServletException {
        uService = new UserService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = uService.selectById(id);
		request.setAttribute("u", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/user_edit.jsp");
		dispatcher.forward(request, response);
	}
}
