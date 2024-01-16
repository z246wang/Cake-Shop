package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import model.User;
import utils.DBUtil;

public class UserDaoImpl implements UserDao {

    private final QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());

    public void addUser(User user) throws SQLException {
        final String sql = "insert into user(username,email,password,name,phone,address,isadmin,isvalidate) values(?,?,?,?,?,?,?,?)";
        queryRunner.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getName(), user.getPhone(), user.getAddress(), user.isIsadmin(), user.isIsvalidate());
    }

    public boolean isUsernameExist(String username) throws SQLException {
        final String sql = "select * from user where username = ?";
        User user = queryRunner.query(sql, new BeanHandler<>(User.class), username);
        return user != null;
    }

    public boolean isEmailExist(String email) throws SQLException {
        final String sql = "select * from user where email = ?";
        User user = queryRunner.query(sql, new BeanHandler<>(User.class), email);
        return user != null;
    }

    public User selectByUsernamePassword(String username, String password) throws SQLException {
        final String sql = "select * from user where username=? and password=?";
        return queryRunner.query(sql, new BeanHandler<>(User.class), username, password);
    }

    public User selectByEmailPassword(String email, String password) throws SQLException {
        final String sql = "select * from user where email=? and password=?";
        return queryRunner.query(sql, new BeanHandler<>(User.class), email, password);
    }

    public User selectById(int id) throws SQLException {
        final String sql = "select * from user where id=?";
        return queryRunner.query(sql, new BeanHandler<>(User.class), id);
    }

    public void updateUserAddress(User user) throws SQLException {
        final String sql = "update user set name = ?,phone=?,address=? where id = ?";
        queryRunner.update(sql, user.getName(), user.getPhone(), user.getAddress(), user.getId());
    }

    public void updatePwd(User user) throws SQLException {
        final String sql = "update user set password = ? where id = ?";
        queryRunner.update(sql, user.getPassword(), user.getId());
    }

    public int selectUserCount() throws SQLException {
        final String sql = "select count(*) from user";
        return queryRunner.query(sql, new ScalarHandler<Long>()).intValue();
    }

    public List<User> selectUserList(int pageNo, int pageSize) throws SQLException {
        final String sql = "select * from user limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<>(User.class), (pageNo - 1) * pageSize, pageSize);
    }

    public void delete(int id) throws SQLException {
        final String sql = "delete from user where id = ?";
        queryRunner.update(sql, id);
    }
}
