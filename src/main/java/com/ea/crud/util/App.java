package com.ea.crud.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ea.crud.service.UserService;

public class App {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring-context.xml",
		        		"classpath:persistence-context.xml"
		        		}
    		);

		UserService userService = (UserService) appContext.getBean("userService");

		userService.findByEmail("fsfs");
		
		System.out.println("before closing main");
	}
}