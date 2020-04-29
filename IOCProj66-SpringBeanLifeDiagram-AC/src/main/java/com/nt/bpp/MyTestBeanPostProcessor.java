package com.nt.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyTestBeanPostProcessor implements BeanPostProcessor {
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		 System.out.println("MyTestBeanPostProcessor.postProcessBeforeInitialization(-,-)");
	  return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyTestBeanPostProcessor.postProcessAfterInitialization(-,-)");
       return bean;
	}

}
