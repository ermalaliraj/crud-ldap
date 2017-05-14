package com.ea.crud.service;

import static org.junit.Assert.assertNotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.annotation.ExpectedException;

import com.ea.crud.domain.Item;
import com.ea.crud.domain.User;

public class SecurityServiceTest extends AbstractContextSecurityTest{

	protected static final transient Log logger = LogFactory.getLog(SecurityServiceTest.class);
    
	@Autowired
	UserService userService;
	@Autowired
	ItemService itemService;


	@Test
	public void testNewUser() {
		User u = new User("ermal");
		u.setPassword("ermal");
		
		userService.save(u);
		User dbUser = (User) userService.loadUserByUsername("ermal");
		assertNotNull(dbUser);
	}
	
	@Test
	@ExpectedException(AccessDeniedException.class)
	public void testAccessDenied() {
		login("ermalu", "ermalu", "ROLE_INVALID");
		itemService.findAll();
	}
	
	/**
	 * The test will pass since the method has no restrictions.
	 */
	@Test
	public void testNotRestricted() {
		itemService.findById((long)1);
	}
	
	@Test
	public void testInsertItem() {
		login("ermala", "ermala", "ROLE_USER");
		Item i = new Item("item1");
		i = itemService.insert(i);
	}

	@Test
	@ExpectedException(AccessDeniedException.class)
	public void testDeleteItemDenied() {
		login("ermala", "ermala", "ROLE_USER");
		Item i = new Item("item1");
		itemService.delete(i);
	}
	
	@Test
	public void testDeleteItemOK() {
		login("ermala", "ermala", "ROLE_ADMIN");
		Item i = new Item("item1");
		itemService.delete(i);
	}
	
	@Test
	@ExpectedException(AuthenticationException.class)
	public void testInsertItemNoAuth() {
		Item i = new Item("item1");
		i = itemService.insert(i);
		itemService.insert(i);
	}
}
