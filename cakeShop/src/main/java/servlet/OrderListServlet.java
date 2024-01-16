package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;
import model.User;
import service.OrderService;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/order_list")
public class OrderListServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderService oService = new OrderService();
	
	@Override
	public void init() throws ServletException {
		oService = new OrderService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		List<Order> list = oService.selectAll(u.getId());
		request.setAttribute("orderList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/order_list.jsp");
		dispatcher.forward(request, response);
	}
}
