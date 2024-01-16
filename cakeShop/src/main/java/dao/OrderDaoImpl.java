package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import model.Order;
import model.OrderItem;
import utils.DBUtil;

public class OrderDaoImpl implements OrderDao{

	private QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
    
    public void insertOrder(Connection con, Order order) throws SQLException {
        String sql = "insert into `order`(total,amount,status,paytype,name,phone,address,datetime,user_id) values(?,?,?,?,?,?,?,?,?)";
        queryRunner.update(con, sql,
                order.getTotal(), order.getAmount(), order.getStatus(),
                order.getPaytype(), order.getName(), order.getPhone(),
                order.getAddress(), order.getDatetime(), order.getUser().getId());
    }
    
    public int getLastInsertId(Connection con) throws SQLException {
        String sql = "select last_insert_id()";
        BigInteger bi = queryRunner.query(con, sql, new ScalarHandler<>());
        return Integer.parseInt(bi.toString());
    }
    
    public void insertOrderItem(Connection con, OrderItem item) throws SQLException {
        String sql = "insert into orderitem(price,amount,goods_id,order_id) values(?,?,?,?)";
        queryRunner.update(con, sql, item.getPrice(), item.getAmount(), item.getGoods().getId(), item.getOrder().getId());
    }
    	
    public List<Order> selectAll(int userid) throws SQLException {
        String sql = "select * from `order` where user_id=? order by datetime desc";
        return queryRunner.query(sql, new BeanListHandler<>(Order.class), userid);
    }
    
    public List<OrderItem> selectAllItem(int orderid) throws SQLException {
        String sql = "select i.id,i.price,i.amount,g.name from orderitem i,goods g where order_id=? and i.goods_id=g.id";
        return queryRunner.query(sql, new BeanListHandler<>(OrderItem.class), orderid);
    }
    
	public int getOrderCount(int status) throws SQLException {
		String sql = "";
		if(status==0) {
			sql = "select count(*) from `order`";
			return queryRunner.query(sql, new ScalarHandler<Long>()).intValue();
		}else {
			sql = "select count(*) from `order` where status=?";
			return queryRunner.query(sql, new ScalarHandler<Long>(),status).intValue();
		}
	}
	
	public List<Order> selectOrderList(int status, int pageNo, int pageSize) throws SQLException {
		if(status==0) {
			String sql = "select o.id,o.total,o.amount,o.status,o.paytype,o.name,o.phone,o.address,o.datetime,u.username from `order` o,user u where o.user_id=u.id order by o.datetime desc limit ?,?";
			return queryRunner.query(sql, new BeanListHandler<Order>(Order.class), (pageNo-1)*pageSize,pageSize );
		}else {
			String sql = "select o.id,o.total,o.amount,o.status,o.paytype,o.name,o.phone,o.address,o.datetime,u.username from `order` o,user u where o.user_id=u.id and o.status=? order by o.datetime desc limit ?,?";
			return queryRunner.query(sql, new BeanListHandler<Order>(Order.class),status, (pageNo-1)*pageSize,pageSize );
		}
	}
	
    public void updateStatus(int id, int status) throws SQLException {
        String sql = "update `order` set status=? where id = ?";
        queryRunner.update(sql, status, id);
    }
    
    public void deleteOrder(Connection con, int id) throws SQLException {
        String sql = "delete from `order` where id = ?";
        queryRunner.update(con, sql, id);
    }
    
    public void deleteOrderItem(Connection con, int id) throws SQLException {
        String sql = "delete from orderitem where order_id=?";
        queryRunner.update(con, sql, id);
    }
}
