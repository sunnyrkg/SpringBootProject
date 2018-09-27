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
		httpSession.setAttribute("loggedIn",user);
	}
}
