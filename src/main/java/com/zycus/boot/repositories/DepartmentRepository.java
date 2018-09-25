package com.zycus.boot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zycus.boot.entities.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {

}
