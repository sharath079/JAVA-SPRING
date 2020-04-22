package kun.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kun.config.AppConfig;
import kun.service.InsuranceService;
import kun.service.InsuranceServiceIMPL;
import kun.service.UserService;
import kun.service.UserServiceIMPL;
import kun.service.VehicleService;
import kun.service.VehicleServiceIMPL;

public class InsertTest {

	public static void main(String[] args) {
		ApplicationContext ctx;
		UserService service;
		InsuranceService insService;
		VehicleService vservice;
		
		//String msg;
		
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		//get service bean
		service=ctx.getBean("userService",UserServiceIMPL.class);
		insService=ctx.getBean("insService",InsuranceServiceIMPL.class);
		vservice=ctx.getBean("vehService",VehicleServiceIMPL.class);
		
		
		try {
			
		// call service method insert		
		service.insert(6, "Kiran", "kiran1234", "male", "Indian", "LIC444", 2);
		// setting insurance details
		
		insService.InsInsert(2006, "TATA-AIG", "INS-AIG-04", "2-YEARS", 6);
		vservice.vInsert(1006, "Lakshmi-Volva", "4-Wheeler", "TS10BN9999", "VOLVA", "GEAR", "WHITE", "2-16-2020", "0", 6);
	    
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		((AbstractApplicationContext) ctx).close();
	}
	
}
