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
		
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		//get service bean
		service=ctx.getBean("userService",UserServiceIMPL.class);
		insService=ctx.getBean("insService",InsuranceServiceIMPL.class);
		vservice=ctx.getBean("vehService",VehicleServiceIMPL.class);
		
		
		try {
			
		// call service method insert		
		//service.insert(7, "Verma", "verma1234", "male", "Indian", "LIC666", 2);
		// setting insurance details
		
		//insService.InsInsert(2007, "TATA-AIG", "INS-AIG-05", "3-YEARS", 7);
		//vservice.vInsert(1007, "Lakshmi-Honda", "2-Wheeler", "TS10BN2000", "ACTIVA", "NO-GEAR", "WHITE", "3-16-2020", "0", 7);
	    
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		((AbstractApplicationContext) ctx).close();
	}
	
}
