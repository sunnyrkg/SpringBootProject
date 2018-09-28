package com.zycus.boot.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpAsyncRequestControl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zycus.boot.entities.Event;
import com.zycus.boot.entities.User;
import com.zycus.boot.services.EventService;
import com.zycus.boot.services.LoginService;
import com.zycus.boot.services.UserService;

@RestController
@RequestMapping(path="/session-services")
public class SessionServices{
	@Autowired
	LoginService loginService;
	@Autowired
	UserService userService;
	@Autowired
	EventService eventService;
	@RequestMapping(path="/get-loggedinuser",consumes="*", produces="application/json",method=RequestMethod.GET)
	public @ResponseBody User getLoggedInUser(HttpServletRequest httpServletRequest)
	{
		return loginService.getLoggedInUser(httpServletRequest.getSession());
	}
	@RequestMapping(path="/get-loggedinuser-statics",consumes="*", produces="application/json",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getStatics(HttpServletRequest httpServletRequest,Model model) throws Exception
	{
		Map<String,Object> map = new HashMap<>();
		User user = loginService.getLoggedInUser(httpServletRequest.getSession());
		Integer numberOfEventRaised = eventService.getNumberOfEventRaisedBy(user);
		Integer numberOfDraftedEvent = eventService.getNumberOfDraftedEventRaisedBy(user);
		map.put("numberOfEventRaised", numberOfEventRaised);
		return map;
	}
}
