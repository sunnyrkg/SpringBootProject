package com.zycus.boot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zycus.boot.entities.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {
	
	@Query("SELECT S FROM SKILL S WHERE S.skillName = :skillName")
	public Iterable<Skill> findByName(@Param("skillName") String skillName);

}
