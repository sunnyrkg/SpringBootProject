package com.zycus.boot.repositories;

import org.springframework.data.repository.CrudRepository;

import antlr.debug.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
