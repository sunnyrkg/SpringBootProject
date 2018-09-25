package com.zycus.boot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zycus.boot.entities.Designation;

@Repository
public interface DesignationRepository extends CrudRepository<Designation, Long> {

}
