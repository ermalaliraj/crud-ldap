package com.ea.crud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String description;
	
	public Item() {
		super();
	}

	public Item(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean equals(final Object other) {
        if (!(other instanceof Item))
            return false;
        Item credit = (Item) other;
      
        return new EqualsBuilder()
        		.append(id, credit.id)
        		.append(name, name)
        		.append(description, description)
        		.isEquals();
    }
    public int hashCode() {
        return new HashCodeBuilder()
        		.append(id)
        		.append(name)
        		.append(description)
        		.toHashCode();
    }
	public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        	.appendSuper(super.toString())
        	.append("id", id)
        	.append("name", name)
        	.append("description", description)
        	.toString();
    }

}
