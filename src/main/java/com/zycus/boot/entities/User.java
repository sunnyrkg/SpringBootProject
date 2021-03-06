package com.zycus.boot.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.zycus.enums.UserRole;

@Entity
@Table(name="person")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	@Enumerated(EnumType.STRING)
	private UserRole role;
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="skill")
	private Set<Skill> skills;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public Set<Skill> getSkills() {
		return skills;
	}
	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
	public boolean containsSkill(Object o) {
		return skills.contains(o);
	}
	public boolean addSkill(Skill e) {
		if(this.skills==null)
		{
			this.skills = new HashSet<>();
		}
		return skills.add(e);
	}
	public boolean containsAllSkills(Collection<?> c) {
		return skills.containsAll(c);
	}
	public boolean addAllSkills(Collection<? extends Skill> c) {
		return skills.addAll(c);
	}
	
	
	
}
