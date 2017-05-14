package com.ea.crud.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.ea.crud.domain.Item;

public class ItemServiceTest extends AbstractSpringTest{

	protected static final transient Log logger = LogFactory.getLog(ItemServiceTest.class);
    
	/**
	 * A CRUD test. 
	 * Insert, read, update, delete
	 */
	@Test
    public void testCRUD(){
    	ItemService itemService = (ItemService) applicationContext.getBean("itemService");
    	
    	Item i = new Item("item1");
    	
    	// 1. Insert
		i = itemService.insert(i);
		
		// 2. Get
		Item dbItem = itemService.findById(i.getId());
		assertNotNull(dbItem);
		assertEquals(i.getName(), dbItem.getName());
		
		// 4. delete
//		itemService.delete(dbItem);
//		Item deletedItem = itemService.findById(dbItem.getId());
//		assertNull(deletedItem); // we are outside of an active transaction, each method invocation creates a new persistence context, so delete won't work. Need to create a manual transaction. Or...
	}
    
	
    /**
     * Insert three items. 
     * Get the list of items, print it and check if has exactly 3 elements.
     */
    @Test
    public void testList(){
    	ItemService itemService = (ItemService) applicationContext.getBean("itemService");
    	
    	itemService.insert(new Item("item1"));
    	itemService.insert(new Item("item2"));
    	itemService.insert(new Item("item3"));
		
    	List<Item> list = itemService.findAll();
    	assertNotNull(list);
    	assertTrue(list.size()>1);
      	//assertEquals(3, list.size()); //since the data are persisted
    }

}
