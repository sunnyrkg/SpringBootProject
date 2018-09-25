package com.zycus.boot.controllers;

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

import com.zycus.boot.entities.Skill;
import com.zycus.boot.entities.User;
import com.zycus.boot.repositories.SkillRepository;
import com.zycus.boot.repositories.UserRepository;
import com.zycus.boot.services.DepartmentService;
import com.zycus.boot.services.DesignationService;
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

}
