package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;

/**
 * Servlet implementation class AdminGoodsRecommend
 */
@WebServlet("/admin/goods_recommend")
public class AdminGoodsRecommendServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GoodsService gService;

    @Override
    public void init() throws ServletException {
        gService = new GoodsService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String method = request.getParameter("method");
		int typeTarget=Integer.parseInt(request.getParameter("typeTarget"));
		if(method.equals("add")) {
			gService.addRecommend(id, typeTarget);
		}else {
			gService.removeRecommend(id, typeTarget);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/goods_list");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
