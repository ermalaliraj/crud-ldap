package com.ea.crud.service.impl;

import java.io.Serializable;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ea.crud.dao.UserDAO;
import com.ea.crud.domain.User;
import com.ea.crud.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService, Serializable {
	
	private static final long serialVersionUID = -8625497694332087817L;
	protected static transient Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User register(String email, String password) {
		User user = new User(email);
		user.setPassword(password);
		userDAO.save(user);
		return user;
	}

	@Override
	public User updatePassword(Long userId, String oldPassword, String newPassword) {
		User u = userDAO.findById(userId);
		logger.debug("Got from DB "+u);
		
		if(!u.getPassword().equals(oldPassword)){
			logger.error("User can not set a new password if he don't remeber the old one.");
			//throw new Exception("");
		}
		
		u.setPassword(newPassword);
		return userDAO.update(u);
	}

	@Override
	public User findByEmail(String email) {
		User u = userDAO.findByEmail(email);
		return u;
	}

	@Override
	public User findById(Long id) {
		return userDAO.findById(id);
	}
	
	@Override
	public void delete(User u) {
		userDAO.delete(u);
	}

	@Override
	public Iterator<User> findAllOrderById() {
		return userDAO.findAllOrderById();
	}

	@Override
	public void save(User u) {
		userDAO.save(u);
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
        //logger.info("Login for user '" + username + "'");
        User user = userDAO.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        } else {
            //user.setRoles(getUserRoles(user));
            //logger.info("User '" + user.getUsername() +"' found");
        }

        return user;
	}

}
