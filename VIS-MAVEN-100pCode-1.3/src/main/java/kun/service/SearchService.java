package kun.service;

import java.util.List;

import kun.bo.UserBO;
import kun.dto.SearchDTO;

public interface SearchService {
	
	public List<UserBO> result(SearchDTO sdto) throws Exception;

}
