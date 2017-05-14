package com.ea.crud.service;

import java.util.Iterator;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.ea.crud.domain.User;

public interface UserService extends UserDetailsService {

	public UserDetails loadUserByUsername(String userName);
	
	public User register(String email, String password);

	public User updatePassword(Long userId, String oldPassword, String newPassword);

	// add more methods here
	
	public User findByEmail(String email);
	
	public User findById(Long id);
	
	void delete(User u);

	public Iterator<User> findAllOrderById();

	public void save(User u);
	
}
