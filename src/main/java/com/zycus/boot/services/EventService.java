package com.zycus.boot.services;


import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.boot.entities.Event;
import com.zycus.boot.entities.User;
import com.zycus.boot.repositories.EventRepository;
import com.zycus.enums.EventStatus;
import com.zycus.enums.UserRole;

@Service
public class EventService {
	
	@Autowired
	EventRepository eventRepository;
	
	public Event createNewEvent(Event event)
	{
		return eventRepository.save(event);
	}
	
	public Event findEventById(Integer eventId)
	{
		return eventRepository.findById(eventId).get();
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
	
	public void deleteEventById(Integer eventId)
	{
		eventRepository.deleteById(eventId);
	}
	
	public Event updateEventStatus(Event event,EventStatus eventStatus) 
	{
		event.setEventStatus(eventStatus);
		return eventRepository.save(event);
	}
	public Event publishEvent(Event event)
	{
		return this.updateEventStatus(event, EventStatus.PUBLISHED);
	}
	public Event addPanelToEvent(Event event,User...users)
	{
		Set<User> userSet = new HashSet<>();
		for(User user : users)
		{
			if(user.getRole()==UserRole.PANEL)
			{
				userSet.add(user);
				event.setNumberOfPanels(event.getNumberOfPanels()+1);
			}
		}
		event.getAssignedPanelMembers().addAll(userSet);
		return eventRepository.save(event);
	}
	public Event removePanelFromEvent(Event event, User...users)
	{
		Set<User> userSet = new HashSet<>();
		Set<User> assignedPanelMembers = event.getAssignedPanelMembers();
		for(User user : users)
		{
			if(user.getRole()==UserRole.PANEL)
				userSet.add(user);
		}
		assignedPanelMembers.removeAll(userSet);
		event.setNumberOfPanels(assignedPanelMembers.size());
		return eventRepository.save(event);
	}
	public boolean assignHRToEvent(Event event,User raisedBy)
	{
		if(raisedBy.getRole()==UserRole.HR)
		{
			event.setRaisedBy(raisedBy);
			eventRepository.save(event);
			return true;
		}
		else
			return false;
	}

	public Iterable<Event> getEventsRaiseddBy(User raisedBy) throws Exception {
		// TODO Auto-generated method stub
		if(raisedBy.getRole().equals(UserRole.HR))
		{
			return eventRepository.findEventRaisedBy(raisedBy);
		}
		else throw new Exception("UserRole should be HR");
	}

	public Integer getNumberOfEventRaisedBy(User raisedBy) {
		// TODO Auto-generated method stub
		if(raisedBy.getRole().equals(UserRole.HR))
		{
			return eventRepository.findNumberOfEventRaisedBy(raisedBy);
		}
		else return 0;
	}

	public Integer getNumberOfDraftedEventRaisedBy(User raisedBy) {
		// TODO Auto-generated method stub
		if(raisedBy.getRole().equals(UserRole.HR))
		{
			return eventRepository.findNumberOf(raisedBy, EventStatus.DRAFT);
		}
		else return 0;
	}
	public Integer getNumberOfPublishedEventRaisedBy(User raisedBy)
	{
		if(raisedBy.getRole().equals(UserRole.HR))
		{
			return eventRepository.findNumberOf(raisedBy, EventStatus.PUBLISHED);
		}
		else return 0;
	}
	
}
