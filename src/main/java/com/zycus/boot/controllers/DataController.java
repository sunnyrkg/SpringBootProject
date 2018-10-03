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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zycus.boot.entities.Event;
import com.zycus.boot.entities.User;
import com.zycus.boot.services.DesignationService;
import com.zycus.boot.services.EventService;
import com.zycus.boot.services.LoginService;
import com.zycus.boot.services.SkillService;
import com.zycus.boot.services.UserService;

@RestController
@RequestMapping(path="/data-controller")
public class DataController{
	@Autowired
	LoginService loginService;
	@Autowired
	UserService userService;
	@Autowired
	EventService eventService;
	@Autowired
	DesignationService designationService;
	@Autowired
	SkillService skillService;
	@RequestMapping(path="/get/{data}",consumes="*", produces="application/json",method=RequestMethod.GET)
	public @ResponseBody Object getLoggedInUser(@PathVariable("data") String data)
	{
		switch(data)
		{
			case "designation": return designationService.getAll();
			case "skill":return skillService.findAllSkills();
			default: return null;
		}
	}
}
