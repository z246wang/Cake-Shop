package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import model.Goods;
import model.Recommend;
import utils.DBUtil;

public class GoodsDaoImpl implements GoodsDao{
	
    private QueryRunner getQueryRunner() {
        return new QueryRunner(DBUtil.getDataSource());
    }

    public Map<String, Object> getBestGoods() throws SQLException {
        String sql = "SELECT g.id, g.name, g.cover, g.price FROM recommend r, goods g WHERE type = 1 AND r.goods_id = g.id";
        return getQueryRunner().query(sql, new MapHandler());
    }

    public List<Goods> selectGoods(int typeId, int pageNo, int pageSize, String sortOrder, String sortBy) throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT * FROM goods WHERE 1 = 1");
        if (typeId != 0) {
            sql.append(" AND type_id = ?");
        }
        if ("asc".equalsIgnoreCase(sortOrder) || "desc".equalsIgnoreCase(sortOrder)) {
            sql.append(" ORDER BY ").append(sortBy).append(" ").append(sortOrder);
        }

        sql.append(" LIMIT ?, ?");
        Object[] params;
        if (typeId == 0) {
            params = new Object[]{(pageNo - 1) * pageSize, pageSize};
        } else {
            params = new Object[]{typeId, (pageNo - 1) * pageSize, pageSize};
        }

        return getQueryRunner().query(sql.toString(), new BeanListHandler<>(Goods.class), params);
    }

    public int getGoodsCount(int typeId) throws SQLException {
        String sql = typeId == 0 ? "SELECT COUNT(*) FROM goods" : "SELECT COUNT(*) FROM goods WHERE type_id = ?";
        Object[] params = typeId == 0 ? new Object[]{} : new Object[]{typeId};
        return getQueryRunner().query(sql, new ScalarHandler<Long>(), params).intValue();
    }

    public List<Goods> selectGoodsRecommend(int type, int pageNo, int pageSize) throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT g.id, g.name, g.cover, g.image1, g.image2, g.intro, g.price, g.stock, t.name AS typename FROM goods g, type t WHERE g.type_id = t.id");
        if (type != 0) {
            sql.append(" AND g.id IN (SELECT goods_id FROM recommend WHERE type = ?)");
        }
        sql.append(" LIMIT ?, ?");

        Object[] params = type == 0 ? new Object[]{(pageNo - 1) * pageSize, pageSize} : new Object[]{type, (pageNo - 1) * pageSize, pageSize};
        return getQueryRunner().query(sql.toString(), new BeanListHandler<>(Goods.class), params);
    }
    
    public int selectGoodsRecommendCount(int type) throws SQLException {
        QueryRunner r = getQueryRunner();
        if (type == 0) return getGoodsCount(0);
        String sql = "SELECT COUNT(*) FROM recommend WHERE type=?";
        return r.query(sql, new ScalarHandler<Long>(), type).intValue();
    }

    public Goods getById(int id) throws SQLException {
        QueryRunner r = getQueryRunner();
        String sql = "SELECT g.id, g.name, g.cover, g.image1, g.image2, g.price, g.intro, g.stock, t.id typeid, t.name typename FROM goods g, type t WHERE g.id = ? AND g.type_id = t.id";
        return r.query(sql, new BeanHandler<>(Goods.class), id);
    }

    public int getSearchCount(String keyword) throws SQLException {
        QueryRunner r = getQueryRunner();
        String sql = "SELECT COUNT(*) FROM goods WHERE name LIKE ?";
        return r.query(sql, new ScalarHandler<Long>(), "%" + keyword + "%").intValue();
    }

    public List<Goods> selectSearchGoods(String keyword, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = getQueryRunner();
        String sql = "SELECT * FROM goods WHERE name LIKE ? LIMIT ?, ?";
        return r.query(sql, new BeanListHandler<>(Goods.class), "%" + keyword + "%", (pageNo - 1) * pageSize, pageSize);
    }
    
	public boolean isScroll(Goods g) throws SQLException {
		return isRecommend(g, 1);
	}
	
	private boolean isRecommend(Goods g, int type) throws SQLException {
        QueryRunner r = getQueryRunner();
        String sql = "SELECT * FROM recommend WHERE type = ? AND goods_id = ?";
        Recommend recommend = r.query(sql, new BeanHandler<>(Recommend.class), type, g.getId());
        return recommend != null;
    }

    public void addRecommend(int id, int type) throws SQLException {
        QueryRunner r = getQueryRunner();
        String sql = "INSERT INTO recommend(type, goods_id) VALUES(?, ?)";
        r.update(sql, type, id);
    }

    public void removeRecommend(int id, int type) throws SQLException {
        QueryRunner r = getQueryRunner();
        String sql = "DELETE FROM recommend WHERE type = ? AND goods_id = ?";
        r.update(sql, type, id);
    }

    public void insert(Goods g) throws SQLException {
        QueryRunner r = getQueryRunner();
        String sql = "INSERT INTO goods(name, cover, image1, image2, price, intro, stock, type_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        r.update(sql, g.getName(), g.getCover(), g.getImage1(), g.getImage2(), g.getPrice(), g.getIntro(), g.getStock(), g.getType().getId());
    }

    public void update(Goods g) throws SQLException {
        QueryRunner r = getQueryRunner();
        String sql = "UPDATE goods SET name = ?, cover = ?, image1 = ?, image2 = ?, price = ?, intro = ?, stock = ?, type_id = ? WHERE id = ?";
        r.update(sql, g.getName(), g.getCover(), g.getImage1(), g.getImage2(), g.getPrice(), g.getIntro(), g.getStock(), g.getType().getId(), g.getId());
    }

    public void delete(int id) throws SQLException {
        QueryRunner r = getQueryRunner();
        String sql = "DELETE FROM goods WHERE id = ?";
        r.update(sql, id);
    }
}
