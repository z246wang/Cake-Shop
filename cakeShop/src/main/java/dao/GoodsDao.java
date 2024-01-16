package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.Goods;

public interface GoodsDao {
	
    Map<String, Object> getBestGoods() throws SQLException;
    
    List<Goods> selectGoods(int typeId, int pageNo, int pageSize, String sortOrder, String sortBy) throws SQLException;
    
    int getGoodsCount(int typeId) throws SQLException;
    
    List<Goods> selectGoodsRecommend(int type, int pageNo, int pageSize) throws SQLException;
    
    int selectGoodsRecommendCount(int type) throws SQLException;
    
    Goods getById(int id) throws SQLException;
    
    int getSearchCount(String keyword) throws SQLException;
    
    List<Goods> selectSearchGoods(String keyword, int pageNo, int pageSize) throws SQLException;
    
    boolean isScroll(Goods g) throws SQLException;
    
    void addRecommend(int id, int type) throws SQLException;
    
    void removeRecommend(int id, int type) throws SQLException;
    
    void insert(Goods g) throws SQLException;
    
    void update(Goods g) throws SQLException;
    
    void delete(int id) throws SQLException;
}
