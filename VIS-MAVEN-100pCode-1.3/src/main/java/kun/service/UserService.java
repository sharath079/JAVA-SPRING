package kun.service;

import java.sql.SQLException;
import java.util.List;

import kun.bo.UserBO;
import kun.dto.ByNameDTO;
import kun.dto.UserDTO;

public interface UserService {
	
	public String insert(UserDTO userdto) throws Exception;
    public List<UserBO> retrievalByUserName(ByNameDTO ndto) throws SQLException;
    boolean delete(int id) throws Exception;
}
