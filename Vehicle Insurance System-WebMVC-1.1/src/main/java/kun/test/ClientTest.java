package kun.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kun.bo.UserBO;
import kun.config.AppConfig;
import kun.dao.SearchDAO;
import kun.dao.SearchDAOIMPL;
import kun.dao.UserDAOIMPL;
import kun.dto.SearchDTO;
import kun.service.InsuranceService;
import kun.service.SearchService;
import kun.service.SearchServiceIMPL;
import kun.service.UserService;
import kun.service.VehicleService;
import kun.service.VehicleServiceIMPL;

public class ClientTest {

	public static void main(String[] args) {
	
		ApplicationContext ctx;
		UserService service;
		SearchService sService;
		SearchDAO sdao;
		UserBO ubo;
		
		List<UserBO> list=new ArrayList<UserBO>();
		ctx= new AnnotationConfigApplicationContext(AppConfig.class);
		
		sService=ctx.getBean("searchService",SearchServiceIMPL.class);
		
		try {
			
			SearchDTO sdto = null;
			sdto=new SearchDTO();
			//ubo=sService.result("satish", "LIC111","TSO9BN4567");
			list=sService.result(sdto);
						
			System.out.println("Search results..."+list);
			} 
		catch (Exception e) {
		
			e.printStackTrace();
		}

		((AbstractApplicationContext) ctx).close();
	}
}
