package com.ea.crud.dao.impl;

import java.util.List;

import com.ea.crud.dao.GenericDAO;
import com.ea.crud.dao.ItemDAO;
import com.ea.crud.domain.Item;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ItemDAOImpl<T> extends GenericDAO implements ItemDAO {
	
	protected static final transient Log logger = LogFactory.getLog(ItemDAOImpl.class);
	
	// parameterizing the Type which is been needed in entityManager.find(), supposing 
	// no methods/constructors(which can modify the state) can be added to the class.
	protected Class<T> entityClass; 
	
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void insert(Item item) {
		entityManager.persist(item);
	}

	@Override
	public void delete(Item item) {
		entityManager.remove(item);	
	}

	@Override
	public Item findById(Long id) {
		return (Item) entityManager.find(entityClass, id);
	}

	@Override
	public List<Item> findAll() {
		@SuppressWarnings("unchecked")
		List<Item> list = entityManager.createQuery("select i from Item i order by i.id")
                		.getResultList();
		return list;
	}

	
}
