package kun.dao;

import java.util.List;

import kun.bo.SearchBO;
import kun.bo.UserBO;

public interface SearchDAO {
	
    public List<UserBO> resultTest(SearchBO sbo) throws Exception;
}
