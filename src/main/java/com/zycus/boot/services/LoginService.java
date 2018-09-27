package com.zycus.boot.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.boot.entities.User;

@Service
public class LoginService {
	@Autowired
	UserService userService;
	public boolean validateUser(Integer id,String password)
	{
		User user = userService.getUserById(id);
		if(user!=null)
		{
			if(user.getPassword().compareTo(password)==0) return true; 
			else return false;
		}
		else return false;	
	}
	public void setSessionFor(User user,HttpSession httpSession)
	{
		System.out.println(user.getId() +" is set in session id "+httpSession.getId());
		httpSession.setAttribute("loggedIn",user);
	}
	public User getLoggedInUser(HttpSession httpSession)
	{
		User user = (User) httpSession.getAttribute("loggedIn");
		System.out.println(user.getId() +" is get from session id "+httpSession.getId());
		return user;
	}
}
