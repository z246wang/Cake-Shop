package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;

/**
 * Servlet implementation class AdminOrderDeleteServlet
 */
@WebServlet("/admin/order_delete")
public class AdminOrderDeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderService oService;
	 
	@Override
    public void init() throws ServletException {
        oService = new OrderService();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		oService.delete(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/order_list");
		dispatcher.forward(request, response);
	}
}
