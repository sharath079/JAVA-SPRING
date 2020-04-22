package kun.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<UserBO> result(String username, String licenseNo, String plateNo) throws Exception {
		
		SearchBO sbo=new SearchBO();
		sbo.setUsername(username);
		sbo.setLicenseno(licenseNo);
		sbo.setPlateno(plateNo);
		List<UserBO> list_ubo=new ArrayList<UserBO>();
		
		System.out.println("::"+sbo);
		//use seacrhdao obj
		
		list_ubo=sdao.resultTest(username, licenseNo, plateNo);
		return list_ubo;
	}
}
