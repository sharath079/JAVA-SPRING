package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
@ComponentScan(basePackages = "com.nt")
public class SpringBootProjApplication {

	private static WishMessageGenerator wmg;

	public static void main(String[] args) {
		
		wmg = null;
		
		ApplicationContext ctx=null;
		
		ctx=SpringApplication.run(SpringBootProjApplication.class, args);
	    wmg=ctx.getBean("wmg",WishMessageGenerator.class);
	    
	    System.out.println(wmg.generateWishMessage("Harish"));
	     ((ConfigurableApplicationContext) ctx).close();
	    }
}
