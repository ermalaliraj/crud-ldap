package com.ea.crud.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassUtil {

	public static <T> T getBeanFromSpring(String beanName) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
    			new String[] {
    					"classpath:spring-context.xml",
		        		"classpath:persistence-context.xml"
		        });
		
		@SuppressWarnings("unchecked")
		T object = (T) applicationContext.getBean(beanName);
		return object;

	}
}
