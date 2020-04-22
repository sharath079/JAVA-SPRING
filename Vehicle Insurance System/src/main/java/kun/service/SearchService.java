package kun.service;

import java.util.List;

import kun.bo.UserBO;

public interface SearchService {
	
	public List<UserBO> result(String username,String licenseNo,String plateNo) throws Exception;

}
