package service;

import java.sql.SQLException;
import java.util.List;

import dao.TypeDao;
import dao.TypeDaoImpl;
import model.Type;

public class TypeService {
	private TypeDao tDao;

	public TypeService() {
		this.tDao = new TypeDaoImpl();
	}
	
	//GoodsListServlet
	public Type select(int id) {
		Type t=null;
		try {
			t = tDao.select(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	//Listener
	public List<Type> selectAll(){
		List<Type> list=null;
		try {
			list = tDao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
