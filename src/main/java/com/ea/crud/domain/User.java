package com.ea.crud.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements Serializable, UserDetails {

	private static final long serialVersionUID = -8472447620112441018L;

	@Id
	@GeneratedValue
	private Long id;

	private String email;

	private String password;
	
//	@OneToOne
//	@PrimaryKeyJoinColumn
	private String role = "ROLE_ADMIN";
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
		super();
	}

	public User(final String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public Collection<GrantedAuthority> getRoles() {
		Collection<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(role));
		return roles;
	}

	public boolean equals(final Object other) {
        if (!(other instanceof User))
            return false;
        User credit = (User) other;
      
        return new EqualsBuilder()
        		.append(id, credit.id)
        		.append(email,email)
        		.append(password, password)
        		.isEquals();
    }
    public int hashCode() {
        return new HashCodeBuilder()
        		.append(id)
        		.append(email)
        		.append(password)
        		.toHashCode();
    }
	public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        	.appendSuper(super.toString())
        	.append("id", id)
        	.append("email", email)
        	.append("password", password)
        	.append("role", role)
        	.toString();
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(role));
		return roles;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
