package com.ea.crud.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import com.ea.crud.domain.Item;

public interface ItemService {

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public Item insert(Item i);

	@Secured({"ROLE_ADMIN"})
	public void delete(Item i);

	// for completeness we assume everyone can call this method
	public Item findById(Long id);

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public List<Item> findAll();

}
