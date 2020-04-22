package kun.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kun.bo.UserBO;
import kun.config.AppConfig;
import kun.service.UserService;
import kun.service.UserServiceIMPL;

public class UserDeleteClient {

	public static void main(String[] args) {
		ApplicationContext ctx;
		UserService service;
		List<UserBO> listbo= new ArrayList<UserBO>();
		
        ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		//get service bean
		service=ctx.getBean("userService",UserServiceIMPL.class);
		
		try {
			// delete User based on ID
			//boolean count=service.delete(6);
			//System.out.println(count);
			
			//retrieve user by name
			
			listbo=service.retrievalByUserName("Satish");
			System.out.println("List of Users ::"+listbo);
		}
         catch(Exception e) {
        	 e.printStackTrace();
         }
		((AbstractApplicationContext) ctx).close();
	}
}
