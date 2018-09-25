package com.zycus.boot.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.boot.entities.Department;
import com.zycus.boot.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Department addNewDepartment(String departmentName)
	{
		if(departmentRepository.countByName(departmentName)==0)
		{
			Department department = new Department();
			department.setDepartmentName(departmentName);
			return departmentRepository.save(department);
		}
		else
		{
			return departmentRepository.findByName(departmentName).iterator().next();
		}
		
	}

	public Iterable<Department> addAllDepartment(List<String> departmentNames) {
	
		List<Department> departments = new LinkedList<>();
		for(String departmentName : departmentNames)
		{
			if(departmentRepository.countByName(departmentName)<1)
			{
				Department department = new Department();
				department.setDepartmentName(departmentName);
				departments.add(department);
			}
		}
		return departmentRepository.saveAll(departments);
	}
}
