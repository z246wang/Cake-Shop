package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Goods;
import service.GoodsService;

/**
 * Servlet implementation class AdminGoodsEditshowServelt
 */
@WebServlet("/admin/goods_editshow")
public class AdminGoodsEditshowServelt extends HttpServlet {
	
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
		Goods goods = gService.getById(id);
		request.setAttribute("g", goods);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/goods_edit.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
