package com.zycus.boot.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="_user")
public class User {
	private Long id;
	private String firstName;
	private String lastName;
	@ManyToOne(fetch=FetchType.EAGER)
	private Role role;
	
}
