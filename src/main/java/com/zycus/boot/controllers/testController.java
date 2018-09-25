package com.zycus.boot.controllers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zycus.boot.entities.Skill;
import com.zycus.boot.entities.User;
import com.zycus.boot.repositories.SkillRepository;
import com.zycus.boot.services.UserService;

@Controller
@RequestMapping(path="/test")
public class testController {
	@Autowired
	UserService userService;
	@Autowired
	SkillRepository skillRepository;
	@RequestMapping(path="/userservice",produces="text/plain")
	public @ResponseBody String testUserService()
	{
		User user = new User();
		user.setFirstName("Aman");
		user.setLastName("Gupta");
		Set<Skill> inputSkills = new HashSet<>();
		List<String> skill = new LinkedList<>();
		skill.add("JAVA");
		skill.add("C");
		skill.add("MATH");
		/*Skill skillExist;
		inputSkills.stream().forEach((skill)->{
			if((skillExist = skillRepository.findByName(skill.getSkillName()))!=null)
			{
				skill = s;
				
			}
		});*/
		user.setSkills(new HashSet<Skill>());
		user.addSkill(new Skill("JAVA"));
		user.addSkill(new Skill("C"));
		userService.addNewHR(user);
		return "Executed";
	}

}
