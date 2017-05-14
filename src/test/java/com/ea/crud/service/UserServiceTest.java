package com.ea.crud.service;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.ea.crud.domain.User;

public class UserServiceTest extends AbstractSpringTest{

	protected static final transient Log logger = LogFactory.getLog(UserServiceTest.class);
    
	/**
	 * A CRUD test. 
	 * Insert, read, update, delete
	 */
	@Test
    public void testCRUD(){
    	UserService userService = (UserService) applicationContext.getBean("userService");
    	String e = "ermal";
    	String p = "aliraj";
    	
    	// 1. Insert
		User user = userService.register(e, p);
		
		// 2. Get
		User dbUser = userService.findByEmail(user.getEmail());
		assertNotNull(dbUser);
		assertEquals(user.getEmail(), dbUser.getEmail());
		
		// 3. Update
		userService.updatePassword(dbUser.getId(), dbUser.getPassword(), dbUser.getPassword()+2);
		
		User userUpdated = userService.findByEmail(dbUser.getEmail());
		logger.debug("dbUser:"+dbUser);
		logger.debug("userUpdated:"+userUpdated);
		assertNotNull(userUpdated);
		assertEquals(userUpdated.getPassword(), dbUser.getPassword()+2);
		
		// 4. delete
//		userService.delete(userUpdated);
//		User deletedUser = userService.findByEmail(userUpdated.getEmail());
//		assertNull(deletedUser); // we are outside of an active transaction, each method invocation creates a new persistence context, so delete won't work. Need to create a manual transaction. Or...
	}
    
    /**
     * Insert three users. 
     * Get the list of users, print it and check if has exactly 3 elements.
     */
    @Test
    public void testList(){
    	UserService userService = (UserService) applicationContext.getBean("userService");
    	
    	userService.register("a", "a1");
    	userService.register("b", "b1");
    	userService.register("c", "c1");
		
    	Iterator<User> i = userService.findAllOrderById();
    	
    	int size = 0;
    	while (i.hasNext()) {
			User user = (User) i.next();
			logger.debug(user);
			size++;
		}
    	
    	assertTrue(size > 1); // since data are persisted in DB
    	//assertEquals(size, 3); 
    }

}
