package com.zycus.boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.boot.entities.Department;
import com.zycus.boot.entities.Designation;
import com.zycus.boot.repositories.DesignationRepository;

@Service
public class DesignationService {
	@Autowired
	DesignationRepository designationRepository;
	@Autowired
	DepartmentService departmentService;
	
	public Designation getDesignationByName(String designationName)
	{
		Iterable<Designation> designationIterable = designationRepository.findByName(designationName);
		if(designationIterable.iterator().hasNext())
			return designationIterable.iterator().next();
		else
		{
			return null;
		}
	}
	public Designation createNewDesignation(String designationName,String departmentName)
	{
		Department department = departmentService.addNewDepartment(departmentName);
		Designation designation = new Designation();
		designation.setDesignationName(designationName);
		designation.setDepartment(department);
		return designationRepository.save(designation);
	}
	public Iterable<Designation> getAll() {
		// TODO Auto-generated method stub
		return designationRepository.findAll();
	}
}
