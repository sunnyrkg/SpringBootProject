package com.zycus.boot.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.boot.entities.User;
import com.zycus.boot.repositories.UserRepository;
import com.zycus.enums.UserRole;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	public Iterable<User> getAllUser()
	{
		return userRepository.findAll();
	}
	
	public User getUserById(Long id)
	{
		return userRepository.findById(id).get();
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
}
