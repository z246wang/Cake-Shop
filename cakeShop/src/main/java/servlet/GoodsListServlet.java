package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Page;
import model.Type;
import service.GoodsService;
import service.TypeService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/goods_list")
public class GoodsListServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GoodsService gService;
	private TypeService tService;

	@Override
	public void init() throws ServletException {
		gService = new GoodsService();
		tService = new TypeService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read page info.
		int id = 0;
		if(request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id")) ;
		}
		int pageNo = 1;
		if(request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo")) ;
		}
		
		//read sorting info.
		String sortOrder = request.getParameter("sortOrder");
		String sortBy = request.getParameter("sortBy");
		
		//set goods to display.
		Page page = gService.getGoodsPage(id, pageNo, sortOrder, sortBy);
		request.setAttribute("p", page);
		request.setAttribute("id", id);
		
		//set the type name to display.
		Type type = null;
		if(id!=0) {
			type=tService.select(id);
		}
		request.setAttribute("type", type);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/goods_list.jsp");
		dispatcher.forward(request, response);
	}
}
