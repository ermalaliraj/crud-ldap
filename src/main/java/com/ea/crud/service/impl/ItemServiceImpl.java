package com.ea.crud.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.ea.crud.dao.ItemDAO;
import com.ea.crud.domain.Item;
import com.ea.crud.service.ItemService;

@Aspect
@Service
public class ItemServiceImpl implements ItemService {
	
	protected static transient Log logger = LogFactory.getLog(ItemServiceImpl.class);
	
	private ItemDAO itemDAO;
	
	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	@Override
	public Item insert(Item item) {
		Item i = new Item();
		i.setName(item.getName());
		i.setDescription(item.getDescription());
		itemDAO.insert(i);
		return i;
	}
	
	@Override
	public void delete(Item i) {
		itemDAO.delete(i);
	}
	
	@Override
	public Item findById(Long id) {
		return itemDAO.findById(id);
	}
	
	@Override
	public List<Item> findAll() {
		return itemDAO.findAll();
	}
	
}
