package com.zycus.boot.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Department {
	@Id
	@GeneratedValue
	private Integer id;
	private String departmentName;

	@OneToMany(mappedBy = "department")
	private Set<Designation> designations;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Designation> getDesignations() {
		return designations;
	}

	public void setDesignations(Set<Designation> designations) {
		this.designations = designations;
	}

}
