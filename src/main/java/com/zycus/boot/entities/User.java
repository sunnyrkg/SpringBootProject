package com.zycus.boot.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	@ManyToOne(fetch=FetchType.EAGER)
	private Role role;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="skill")
	private Set<Skill> skills;
	
}
