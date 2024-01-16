package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Page;
import service.OrderService;

/**
 * Servlet implementation class AdminOrderListServlet
 */
@WebServlet("/admin/order_list")
public class AdminOrderListServlet extends HttpServlet {

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
		int status = 0;
		if(request.getParameter("status") != null) {
			status=Integer.parseInt(request.getParameter("status")) ;
		}
		request.setAttribute("status", status);
		int pageNo = 1;
		if(request.getParameter("pageNo") != null) {
			pageNo=Integer.parseInt(request.getParameter("pageNo")) ;
		}
		Page page = oService.getOrderPage(status,pageNo);
		request.setAttribute("p", page);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/order_list.jsp");
		dispatcher.forward(request, response);
	}
}
