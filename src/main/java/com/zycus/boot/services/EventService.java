package com.zycus.boot.services;

import java.util.Date;
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
	
	public void deleteEventById(Long id)
	{
		eventRepository.deleteById(id);
	}
	
	public Event updateEventStatus(Long eventId,EventStatus eventStatus) 
	{
		return eventRepository;
	}

	public Event findEventById(Long id)
	{
		return eventRepository.findById(id).get();
	}
	
	public Event findEventByEventName(String name)
	{
		return eventRepository.findByName(name);
		
	}
	
	public Set<Event> findAllEventsBeforeDate(Date date)
	{
		
	}
	
	public Set<Event> findAllEventsAfterDate(Date date)
	{
		
	}

	public Set<Event> 
	
	
	
	
	
	
	
	
}
