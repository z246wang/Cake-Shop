package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Order;
import model.OrderItem;

public interface OrderDao {
	
    void insertOrder(Connection con, Order order) throws SQLException;
    
    int getLastInsertId(Connection con) throws SQLException;
    
    void insertOrderItem(Connection con, OrderItem item) throws SQLException;
    
    List<Order> selectAll(int userid) throws SQLException;
    
    List<OrderItem> selectAllItem(int orderid) throws SQLException;
    
    int getOrderCount(int status) throws SQLException;
    
    List<Order> selectOrderList(int status, int pageNo, int pageSize) throws SQLException;
    
    void updateStatus(int id, int status) throws SQLException;
    
    void deleteOrder(Connection con, int id) throws SQLException;
    
    void deleteOrderItem(Connection con, int id) throws SQLException;
    
}
