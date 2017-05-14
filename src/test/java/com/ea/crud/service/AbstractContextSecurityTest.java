package com.ea.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Used for tests with login in SpringSecurity context
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/resources/spring-context.xml", 
    "file:src/main/resources/persistence-context.xml", 
	"file:src/main/resources/spring-security.xml"})
abstract public class AbstractContextSecurityTest {

	protected void login(String email, String password, String roleName) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(roleName));
		Authentication authToken = new UsernamePasswordAuthenticationToken (email, password, authorities);
		SecurityContextHolder.getContext().setAuthentication(authToken);
	}
	
	@After
    public void clear() {
        SecurityContextHolder.clearContext();
    }
}