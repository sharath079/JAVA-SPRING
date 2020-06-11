package kun.dao;

import java.sql.SQLException;
import java.util.List;

import kun.bo.ByNameBO;
import kun.bo.UserBO;
import kun.service.UserServiceIMPL;

public interface UserDAO {
	
	public int insert(UserBO userbo) throws Exception;
//boolean save(UserServiceIMPL user);
//	
//	List<UserServiceIMPL> list();
//	
//	UserServiceIMPL get(int id);
//	
    boolean delete(int id) throws Exception;
	
	public List<UserBO> findUserByName(ByNameBO nbo) throws SQLException;

}
