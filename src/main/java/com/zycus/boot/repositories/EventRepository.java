package com.zycus.boot.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zycus.boot.entities.Event;
import com.zycus.boot.entities.User;
import com.zycus.enums.EventStatus;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
	
	@Query("SELECT e FROM Event e WHERE e.eventName = :eventName")
	public Iterable<Event> findEventByName(@Param("eventName") String eventName);
	
	@Query("SELECT e FROM Event e WHERE e.eventStatus = :eventStatus")
	public Iterable<Event> findEventByStatus(@Param("eventStatus") EventStatus eventStatus);
	
	@Query("SELECT e FROM Event e WHERE e.eventTime < :eventTime")
	public Iterable<Event> findEventsBeforeEventTime(@Param("eventTime") Date eventTime);
	
	@Query("SELECT e FROM Event e WHERE e.raisedTime < :raisedTime")
	public Iterable<Event> findEventsBeforeRaisedTime(@Param("raisedTime") Date raisedTime);
	
	@Query("SELECT e FROM Event e WHERE e.raisedBy = :raisedBy")
	public Iterable<Event> findEventRaisedBy(@Param("raisedBy") User user);
}
