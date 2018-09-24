package com.zycus.boot.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Designation
{
	@Id
	@GeneratedValue
	private long designationId;
	private String designationName;
	private int grade;
	private Department department;
	
}
