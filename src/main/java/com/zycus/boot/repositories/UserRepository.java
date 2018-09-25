package com.zycus.boot.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zycus.boot.entities.User;
import com.zycus.enums.UserRole;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("SELECT c FROM User c WHERE c.role = :userRole")
	Iterable<User> findUserByRole(@Param("userRole") UserRole userRole);


}
