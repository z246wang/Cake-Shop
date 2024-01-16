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
 * Servlet implementation class AdminGoodsDeleteServlet
 */
@WebServlet("/admin/goods_delete")
public class AdminGoodsDeleteServlet extends HttpServlet {
	
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
		gService.delete(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/goods_list");
		dispatcher.forward(request, response);
	}
}
