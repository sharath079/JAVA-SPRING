package kun.service;

import kun.bo.UserBO;

public interface SearchService {
	
	public UserBO result(String username,String licenseNo,String plateNo) throws Exception;

}
