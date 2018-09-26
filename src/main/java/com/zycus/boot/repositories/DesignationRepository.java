package com.zycus.boot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zycus.boot.entities.Designation;

@Repository
public interface DesignationRepository extends CrudRepository<Designation, Integer> {

	@Query("SELECT D FROM Designation D WHERE D.designationName = :designationName")
	public Iterable<Designation> findByName(@Param("designationName") String designationName);
}
