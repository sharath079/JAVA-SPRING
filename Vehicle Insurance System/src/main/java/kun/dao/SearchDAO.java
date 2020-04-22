package kun.dao;

import java.util.List;

import kun.bo.SearchBO;
import kun.bo.UserBO;

public interface SearchDAO {
	
    public List<UserBO> resultTest(String name,String license,String plate_no) throws Exception;
}
