package com.ea.crud.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.ea.crud.dao.GenericDAO;
import com.ea.crud.dao.UserDAO;
import com.ea.crud.domain.User;
import javax.persistence.NoResultException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAOImpl<T> extends GenericDAO implements UserDAO {
	
	protected static final transient Log logger = LogFactory.getLog(UserDAOImpl.class);
	
	// parameterizing the Type which is been needed in entityManager.find(), supposing 
	// no methods/constructors(which can modify the state) can be added to the class.
	protected Class<T> entityClass; 
	
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void save(User user) {
		entityManager.persist(user);
	}

	@Override
	public User update(User user) {
		if (user == null){
			throw new IllegalArgumentException("No user specified");
		}
		return (User)entityManager.merge(user);
	}

	@Override
	public void delete(User user) {
		//if(entityManager.contains(user)){ 
			entityManager.remove(user);	
		//}
	}

	@Override
	public User findById(Long id) {
		return (User) entityManager.find(entityClass, id);
	}

	@Override
	public User findByEmail(String email) {
		User u = null;
		
		try {
            if (email == null){
            	throw new ObjectNotFoundException("No user specified", email);
            }
            
            u = (User) entityManager.createQuery("select u from User u where u.email=:email")
                                    .setParameter("email", email)
                                    .getSingleResult();
            return u;
	    } catch (final NoResultException e) {
	    	//throw new ObjectNotFoundException("No User found for email=" +email, email);
	    	return null;
	    }
	}

	@Override
	public Iterator<User> findAllOrderById() {
		@SuppressWarnings("unchecked")
		List<User> list = entityManager.createQuery("select u from User u order by u.id")
                		.getResultList();
		return list.iterator();
	}

}
