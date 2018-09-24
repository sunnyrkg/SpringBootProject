package com.zycus.boot.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Skill {
	@Id
	@GeneratedValue
	private Long id;
	private String skillName;
	@ManyToMany
	@JoinColumn(name="users")
	private Set<User> users;
	
}
