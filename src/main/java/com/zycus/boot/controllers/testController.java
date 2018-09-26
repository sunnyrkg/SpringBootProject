package com.zycus.boot.controllers;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zycus.boot.entities.Event;
import com.zycus.boot.entities.Skill;
import com.zycus.boot.entities.User;
import com.zycus.boot.repositories.EventRepository;
import com.zycus.boot.repositories.SkillRepository;
import com.zycus.boot.repositories.UserRepository;
import com.zycus.boot.services.DepartmentService;
import com.zycus.boot.services.DesignationService;
import com.zycus.boot.services.SkillService;
import com.zycus.boot.services.UserService;
import com.zycus.enums.EventStatus;

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
	EventRepository eventRepository;
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
		Event event = new Event();
		event.setEventTime(new Date());
		event.setRaisedTime(new Date());
		event.setEventName("RECRUITMENT OF JAVA IIIT");
		event.setEventStatus(EventStatus.DRAFT);
		event.setNumberOfPanelsRequired(5);
		event.setRaisedBy(userService.getUserById(7L));
		event.setSkillSetRequired(new HashSet<>());
		event.getSkillSetRequired().addAll(skillService.findByNamesIfNotExistCreateItAndReturnIterableOfIt("JAVA","C","MATH","APTITUDE"));
		event.setDesignationRequiredForPanel(designationService.getDesignationByName("Pantry Manager"));
		eventRepository.save(event);
		return "Executed";
		
	}

}
