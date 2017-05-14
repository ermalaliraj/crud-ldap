package com.ea.crud.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = 2754769147166111640L;
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_READ = "ROLE_USER";
	
	@Id
	@GeneratedValue
    private String id;
    private String description;
    
    public Role(){
    }
    
    public Role(String id){
    	this.id=id;
    }
    
    public String getAuthority() {
        return id;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public boolean equals(final Object other) {
        if (!(other instanceof Role))
            return false;
        Role castOther = (Role) other;
        return new EqualsBuilder().append(id, castOther.id).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(id).toHashCode();
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString())
        	.append("id", id)
        	.append("description", description)
        	.toString();
    }

}