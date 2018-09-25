package com.zycus.boot.controllers;

import java.util.HashSet;
import java.util.Iterator;
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
		List<String> skillNames = new LinkedList<>();
		skillNames.add("JAVA");
		skillNames.add("C");
		skillNames.add("MATH");
		Iterable<Skill> skills = skillRepository.findByName(skillNames);
		Iterator<Skill> skillIterator = skills.iterator();
		user.setSkills(new HashSet<>());
		while(skillIterator.hasNext())
		{
			user.addSkill(skillIterator.next());
		}
		return "Executed";
	}

}
