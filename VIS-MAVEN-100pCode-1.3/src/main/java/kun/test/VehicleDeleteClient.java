package kun.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kun.config.AppConfig;
import kun.service.VehicleService;
import kun.service.VehicleServiceIMPL;

public class VehicleDeleteClient {

	
	public static void main(String[] args) {
		
	}

	public VehicleService service() {
		ApplicationContext ctx;
		VehicleService vservice;
		ctx= new AnnotationConfigApplicationContext(AppConfig.class);
		
		vservice=ctx.getBean("vehService",VehicleServiceIMPL.class);
		return vservice;
		}

}
