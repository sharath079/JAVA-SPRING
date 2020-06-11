package kun.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kun.bo.InsuranceBO;
import kun.config.AppConfig;
import kun.service.InsuranceService;
import kun.service.InsuranceServiceIMPL;

public class InsuranceClient {

	public InsuranceService service() 
	{
		ApplicationContext ctx;
		InsuranceService iservice;
		ctx= new AnnotationConfigApplicationContext(AppConfig.class);
		
		iservice=ctx.getBean("insService",InsuranceServiceIMPL.class);
		return iservice;
	}
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = null;
		InsuranceService iservice;
		List<InsuranceBO> list_ins= new ArrayList<InsuranceBO>();
        
		ctx= new AnnotationConfigApplicationContext(AppConfig.class);

		 // get vehService bean
		iservice=ctx.getBean("insService",InsuranceServiceIMPL.class);
		
		try {
			list_ins=iservice.findByInsuranceId(2000);
			
			// displaying results
			 
			 System.out.println("Insurance Details By Insurance ID ::");
			 System.out.println(list_ins);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	    finally {
	    	((AbstractApplicationContext) ctx).close();
	    }
		
}//main
	
}
