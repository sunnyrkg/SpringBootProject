package com.zycus.boot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zycus.boot.entities.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer> {

	@Query("SELECT COUNT(D) FROM Department D WHERE D.departmentName = :departmentName")
	Integer countByName(@Param("departmentName") String departmentName);
	
	@Query("SELECT D FROM Department D WHERE D.departmentName = :departmentName")
	Iterable<Department> findByName(@Param("departmentName") String departmentName);

}
