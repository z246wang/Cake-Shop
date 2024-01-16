package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Goods;
import model.Order;
import service.GoodsService;

/**
 * Servlet implementation class GoodsBuyServlet
 */
@WebServlet("/goods_buy")
public class GoodsBuyServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GoodsService gService;
	
	@Override
	public void init() throws ServletException {
		gService = new GoodsService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order = null;
		HttpSession session = request.getSession();
		
		//setup orders
		if(session.getAttribute("order") == null) {
			order = new Order();
			session.setAttribute("order", order);
		}else {
			order = (Order)session.getAttribute("order");
		}
		
		//add selected good to the order.
		int goodsid = Integer.parseInt(request.getParameter("goodsid"));
		Goods goods = gService.getById(goodsid);
		order.addGoods(goods);
		//for layers to print out msg.
		response.getWriter().print("ok");
	}
}
