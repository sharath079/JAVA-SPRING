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
		VehicleService vservice;
		InsuranceService insService;
		SearchService sService;
		SearchDAO sdao;
		UserDAOIMPL dao;
		UserBO ubo;
		
		String msg;
		
		List<UserBO> list=new ArrayList<UserBO>();
		ctx= new AnnotationConfigApplicationContext(AppConfig.class);
		
		sdao=ctx.getBean("searchDAO",SearchDAOIMPL.class);
		
		try {
				
        //msg=insService.InsInsert(2001, "ICICI LOMBARD","INS-LOMBARD-002","02-15-2021",3);
        //System.out.println("::"+msg);
			
			//ubo=sService.result("satish", "LIC111","TSO9BN4567");
			list=sdao.resultTest("Satish","LIC111","TS09BN4567");
						
			System.out.println("Search results..."+list);
			} 
		catch (Exception e) {
		
			e.printStackTrace();
		}

		((AbstractApplicationContext) ctx).close();
	}

}
