package com.ea.crud.dao;

import java.util.List;

import com.ea.crud.domain.Item;

public interface ItemDAO {

	void insert(Item item);
	
	void delete(Item item);

	Item findById(Long id);
	
	List<Item> findAll();
	
}
