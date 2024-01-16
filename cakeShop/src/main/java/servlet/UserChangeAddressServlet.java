package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import model.User;
import service.UserService;

/**
 * Servlet implementation class UserChangeAddressServlet
 */
@WebServlet("/user_changeAddress")
public class UserChangeAddressServlet extends HttpServlet {
	
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
		//load the current user.
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		//copy new parameters to the user.
		try {
			BeanUtils.copyProperties(u, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		uService.updateUserAddress(u);
		request.setAttribute("msg", "Update Success!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user_center.jsp");
		dispatcher.forward(request, response);
	}

}
