package com.zycus.boot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Role {
	@Id
	@GeneratedValue
	private Integer id;
	private String roleName;
	private int level;
}	
