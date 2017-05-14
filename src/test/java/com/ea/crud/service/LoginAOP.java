package com.ea.crud.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class LoginAOP extends AbstractSpringTest{

	protected static final transient Log logger = LogFactory.getLog(LoginAOP.class);
   
	/**
	 * Each login will be logged
	 */
	@Test
    public void testCRUD(){
		UserService userService = (UserService) applicationContext.getBean("userService");
    	
		try {
			userService.loadUserByUsername("ermal");
		} catch (UsernameNotFoundException e) {
			;
		}
	}
}
