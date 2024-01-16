package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import model.Order;
import model.User;
import service.OrderService;

/**
 * Servlet implementation class OrderConfirmServlet
 */
@WebServlet("/order_success")
public class OrderConfirmServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderService oService;
	
	@Override
	public void init() throws ServletException {
		oService = new OrderService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read order info.
		HttpSession session = request.getSession();
		Order order = (Order)session.getAttribute("order");
		
		//copy the info.
		try {
			BeanUtils.copyProperties(order, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//change order status and info.
		order.setDatetime(LocalDateTime.now());
		order.setStatus(2);
		order.setUser((User)session.getAttribute("user"));
		oService.addOrder(order);
		session.removeAttribute("order");
		
		request.setAttribute("msg", "Payment Received!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/order_success.jsp");
		dispatcher.forward(request, response);
	}
}
