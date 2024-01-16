package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Page;
import service.GoodsService;

/**
 * Servlet implementation class GoodsSearchServlet
 */
@WebServlet("/goods_search")
public class GoodsSearchServlet extends HttpServlet {
	
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
		//read search and page info.
		String keyword = request.getParameter("keyword");
		int pageNo = 1;
		if(request.getParameter("pageNo") != null) {
			pageNo=Integer.parseInt(request.getParameter("pageNo") ) ;
		}
		Page page = gService.getSearchGoodsPage(keyword, pageNo);
	
		request.setAttribute("p", page);
		request.setAttribute("keyword", keyword);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/goods_search.jsp");
		dispatcher.forward(request, response);
	}
}
