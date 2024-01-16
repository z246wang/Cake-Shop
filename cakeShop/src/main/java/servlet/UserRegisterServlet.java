package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import model.User;
import service.UserService;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/user_register")
public class UserRegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserService uService;
	
	@Override
	public void init() throws ServletException {
		uService = new UserService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//create a new user.
		User user = new User();
		
		//copy the parameters to the new user.
		try {
			BeanUtils.copyProperties(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//check register success or not.
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_login.jsp");
		if(uService.register(user)) {
			request.setAttribute("msg", "Register Success!");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("msg", "Existing User!");
			dispatcher.forward(request, response);
		}
	}
}
