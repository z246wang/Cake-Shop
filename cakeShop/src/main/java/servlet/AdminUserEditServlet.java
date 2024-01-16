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
 * Servlet implementation class AdminUserEditServlet
 */
@WebServlet("/admin/user_edit")
public class AdminUserEditServlet extends HttpServlet {
	
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
		User u = new User();
		try {
			BeanUtils.copyProperties(u, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		uService.updateUserAddress(u);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/user_list");
		dispatcher.forward(request, response);
	}
}
