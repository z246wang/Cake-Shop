package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.GoodsDao;
import dao.GoodsDaoImpl;
import model.Goods;
import model.Page;

public class GoodsService {
	private GoodsDao gDao;
	
	public GoodsService() {
		this.gDao = new GoodsDaoImpl();
	}

	//IndexServlet
	public Map<String,Object> getBestGoods(){
		Map<String, Object> map = null;
		try {
			map = gDao.getBestGoods();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	//GoodsBuy/GoodsDetail/AdminEditshow
	public Goods getById(int id) {
		Goods g=null;
		try {
			g = gDao.getById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}
	
	//GoodsListServlet
	public Page getGoodsPage(int typeId, int pageNo, String sortOrder, String sortBy) {
	    Page p = new Page();
	    p.setPageNo(pageNo);
	    int totalCount = 0;
	    try {
	        totalCount = gDao.getGoodsCount(typeId);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    p.setPageSizeAndTotalCount(8, totalCount);
	    List list = null;
	    try {
	        list = gDao.selectGoods(typeId, pageNo, 8, sortOrder, sortBy);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    p.setList(list);
	    return p;
	}

	
	//GoodsSearchServlet
	public Page getSearchGoodsPage(String keyword, int pageNo) {
		Page p = new Page();
		p.setPageNo(pageNo);
		int totalCount = 0;
		try {
			totalCount = gDao.getSearchCount(keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(8, totalCount);
		List list=null;
		try {
			list = gDao.selectSearchGoods(keyword,pageNo,8);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		p.setList(list);
		return p;
	}
	
	//AdminGoodsListServlet
	public Page getGoodsRecommendPage(int type,int pageNo) {
		Page p = new Page();
		p.setPageNo(pageNo);
		int totalCount = 0;
		try {
			totalCount = gDao.selectGoodsRecommendCount(type);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(8, totalCount);
		List list=null;
		try {
			list = gDao.selectGoodsRecommend(type, pageNo, 8);
			for(Goods g : (List<Goods>)list) {
				g.setScroll(gDao.isScroll(g));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		p.setList(list);
		return p;
	}
	
	//AdminGoodsRecommendServlet
	public void addRecommend(int id,int type) {
		try {
			gDao.addRecommend(id, type);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	//AdminGoodsRecommendServlet
	public void removeRecommend(int id,int type) {
		try {
			gDao.removeRecommend(id, type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//AdminGoodsAddServlet
	public void insert(Goods goods) {
		try {
			gDao.insert(goods);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//AdminGoodsEditServlet
	public void update(Goods goods) {
		try {
			gDao.update(goods);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//AdminGoodsDeleteServlet
	public void delete(int id) {
		try {
			gDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
