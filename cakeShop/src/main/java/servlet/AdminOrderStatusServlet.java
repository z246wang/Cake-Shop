package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;

/**
 * Servlet implementation class AdminOrderStatusServlet
 */
@WebServlet("/admin/order_status")
public class AdminOrderStatusServlet extends HttpServlet {
	
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
		int status = Integer.parseInt(request.getParameter("status"));
		oService.updateStatus(id, status);
		response.sendRedirect(request.getContextPath()+"/admin/order_list");
	}
}
