package kun.service;

import java.sql.SQLException;
import java.util.List;

import kun.bo.UserBO;

public interface UserService {
	
	public String insert(int id,String name,String password,String gender,String nationality,String license,int authority_id) throws Exception;
    public List<UserBO> retrievalByUserName(String name) throws SQLException;
    boolean delete(int id) throws Exception;
}
