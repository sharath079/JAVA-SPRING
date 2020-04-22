package kun.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kun.bo.VehicleBO;
import kun.config.AppConfig;
import kun.service.VehicleService;
import kun.service.VehicleServiceIMPL;

public class VehicleClient {

	public static void main(String[] args) {
		
		ApplicationContext ctx = null;
		VehicleService vservice;
		List<VehicleBO> list_veh= new ArrayList<VehicleBO>();
        
		ctx= new AnnotationConfigApplicationContext(AppConfig.class);
		 // get vehService bean
		 vservice=ctx.getBean("vehService",VehicleServiceIMPL.class);
		 
		 // getting results by calling service method
		 
		 try {
			
			 list_veh=vservice.findByVehicleId(1001);
			 // displaying results
			 
			 System.out.println("Vehicle Details By Vehicle ID ::");
			 System.out.println(list_veh);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 ((AbstractApplicationContext) ctx).close();
	}

}
