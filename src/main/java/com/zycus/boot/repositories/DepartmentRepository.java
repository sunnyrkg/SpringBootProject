package com.zycus.boot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zycus.boot.entities.Department;

public interface DepartmentRepository extends CrudRepository<Department,Long> {

}
