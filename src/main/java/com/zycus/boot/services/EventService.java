package com.zycus.boot.services;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.boot.entities.Event;
import com.zycus.boot.repositories.EventRepository;
import com.zycus.enums.EventStatus;

@Service
public class EventService {
	
	@Autowired
	EventRepository eventRepository;
	
	public Event createNewEvent(Event event)
	{
		return eventRepository.save(event);
	}
	
	public Iterable<Event> getEventsByName(String name)
	{
		return eventRepository.findEventByName(name);
		
	}
	
	public Iterable<Event> getDraftedEvents()
	{
		return eventRepository.findEventByStatus(EventStatus.DRAFT);
		
	}
	
	public Iterable<Event> getPublishedEvents()
	{
		return eventRepository.findEventByStatus(EventStatus.PUBLISHED);
		
	}
	
	public Iterable<Event> getClosedEvents()
	{
		return eventRepository.findEventByStatus(EventStatus.CLOSED);
		
	}
	
	public void deleteEventById(Long id)
	{
		eventRepository.deleteById(id);
	}
	
	public Event updateEventStatus(Long eventId,EventStatus eventStatus) 
	{
		return eventRepository;
	}

	public void assignHR()
	{
		
	}
	public Event findEventById(Long id)
	{
		return eventRepository.findById(id).get();
	}
	
	
	public Set<Event> findAllEventsBeforeDate(Date date)
	{
		
	}
	
	public Set<Event> findAllEventsAfterDate(Date date)
	{
		
	}

	public Set<Event> 
	
	
	
	
	
	
	
	
}
