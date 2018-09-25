package com.zycus.boot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zycus.boot.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
