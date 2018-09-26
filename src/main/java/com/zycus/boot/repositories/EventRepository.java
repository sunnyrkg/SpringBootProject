package com.zycus.boot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zycus.boot.entities.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

	
}
