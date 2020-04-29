package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.TestBean;

public class SpringBeanLifeCycleTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		TestBean tb=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean class object
		tb=ctx.getBean("tb",TestBean.class);
		//invoke method
		System.out.println("result::"+tb.sayHello("raja"));
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
		

	}

}
