package kun.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kun.bo.SearchBO;
import kun.bo.UserBO;
import kun.dao.SearchDAO;
import kun.dto.SearchDTO;

@Service("searchService")
public class SearchServiceIMPL implements SearchService {

	UserBO ubo;
	
	@Autowired
	SearchDAO sdao;
	
	@Override
	public List<UserBO> result(SearchDTO sdto) throws Exception {
		
		SearchBO sbo=new SearchBO();
		BeanUtils.copyProperties(sdto, sbo);
		
		List<UserBO> list_user=new ArrayList<UserBO>();
		System.out.println("::"+sbo);
		//use seacrhdao obj
		
		list_user=sdao.resultTest(sbo);
		return list_user;
	}
}
