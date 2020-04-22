package kun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kun.bo.SearchBO;
import kun.bo.UserBO;
import kun.dao.SearchDAO;
import kun.dao.SearchDAOIMPL;

@Service("searchService")
public class SearchServiceIMPL implements SearchService {

	UserBO ubo;
	
	@Autowired
	SearchDAO sdao;
	
	@Override
	public UserBO result(String username, String licenseNo, String plateNo) throws Exception {
		
		SearchBO sbo=new SearchBO();
		sbo.setUsername(username);
		sbo.setLicenseno(licenseNo);
		sbo.setPlateno(plateNo);
		
		System.out.println("::"+sbo);
		//use seacrhdao obj
		
		sdao=new SearchDAOIMPL();
		return ubo;
	}
}
