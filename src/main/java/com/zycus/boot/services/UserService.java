package com.zycus.boot.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.boot.entities.Event;
import com.zycus.boot.entities.User;
import com.zycus.boot.repositories.EventRepository;
import com.zycus.boot.repositories.UserRepository;
import com.zycus.enums.UserRole;

@Service
public class UserService {
	@Autowired
	private EventService eventService;
	@Autowired
	private UserRepository userRepository;
	public Iterable<User> getAllUser()
	{
		return userRepository.findAll();
	}
	
	public User getUserById(Integer id)
	{
		try {
				return userRepository.findById(id).get();
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
	}
	
	public Iterable<User> getUserByRole(UserRole userRole)
	{
		return userRepository.findUserByRole(userRole);
	}
	
	public User addNewHR(User user)
	{
		user.setRole(UserRole.HR);
		user.setId(null);
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}
	public User addNewPanel(User user)
	{
		user.setRole(UserRole.PANEL);
		user.setId(null);
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}

	public Iterable<Event> raisedEventByHR(User user) throws Exception {
		// TODO Auto-generated method stub
		return eventService.getEventsRaiseddBy(user);
	}
}
