package com.zycus.boot.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zycus.boot.entities.Event;
import com.zycus.boot.services.DepartmentService;
import com.zycus.boot.services.DesignationService;
import com.zycus.boot.services.EventService;
import com.zycus.boot.services.SkillService;
import com.zycus.boot.services.UserService;

@Controller
@RequestMapping(path="/test")
public class testController {
	@Autowired
	UserService userService;
	@Autowired
	SkillService skillService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	DesignationService designationService;
	@Autowired
	EventService eventService;
	@RequestMapping(path="/userservice",produces="text/plain")
	public @ResponseBody String testUserService()
	{
		Map<String,String> designations = new HashMap<>();
		designations.put("Social","Welfare Engineer");
		designations.put("Social", "Responsible");
		designations.put("Pantry", "Pantry Manager");
		designations.forEach((department,designation)->{
			designationService.createNewDesignation(designation, department);
		});
		return "Executed";
	}
	@RequestMapping(path="/eventservices",produces="text/plain")
	public @ResponseBody String testEventServices()
	{
		Event event = eventService.findEventById(16);
		eventService.addPanelToEvent(event,userService.getUserById(4),userService.getUserById(6));
		return "Executed";
		
	}
	@RequestMapping(path="/out/eventservices",produces="application/json")
	public @ResponseBody Event testEventServicesOut()
	{
		Event event = eventService.findEventById(16);
		return eventService.removePanelFromEvent(event, userService.getUserById(6));
	}

}
