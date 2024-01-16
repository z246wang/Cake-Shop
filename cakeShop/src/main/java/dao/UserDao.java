package dao;

import java.sql.SQLException;
import java.util.List;
import model.User;

public interface UserDao {
	
    void addUser(User user) throws SQLException;
    
    boolean isUsernameExist(String username) throws SQLException;
    
    boolean isEmailExist(String email) throws SQLException;
    
    User selectByUsernamePassword(String username, String password) throws SQLException;
    
    User selectByEmailPassword(String email, String password) throws SQLException;
    
    User selectById(int id) throws SQLException;
    
    void updateUserAddress(User user) throws SQLException;
    
    void updatePwd(User user) throws SQLException;
    
    int selectUserCount() throws SQLException;
    
    List<User> selectUserList(int pageNo, int pageSize) throws SQLException;
    
    void delete(int id) throws SQLException;
}

