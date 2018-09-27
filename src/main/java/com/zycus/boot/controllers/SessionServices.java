package com.zycus.boot.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zycus.boot.entities.User;
import com.zycus.boot.services.LoginService;

@RestController
@RequestMapping(path="/session-services")
public class SessionServices{
	@Autowired
	LoginService loginService;
	@RequestMapping(path="/get-loggedinuser",consumes="*", produces="plain/text",method=RequestMethod.GET)
	public @ResponseBody String getLoggedInUser(HttpServletRequest httpServletRequest)
	{
		return loginService.getLoggedInUser(httpServletRequest.getSession()).getFirstName();
	}
	
}
