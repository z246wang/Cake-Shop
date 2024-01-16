package dao;

import java.sql.SQLException;
import java.util.List;
import model.Type;

public interface TypeDao {
    List<Type> selectAll() throws SQLException;
    
    Type select(int id) throws SQLException;
}
