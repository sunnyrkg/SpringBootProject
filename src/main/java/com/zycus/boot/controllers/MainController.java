package com.zycus.boot.controllers;

import java.net.Authenticator.RequestorType;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zycus.boot.entities.Event;
import com.zycus.boot.entities.User;
import com.zycus.boot.services.DepartmentService;
import com.zycus.boot.services.DesignationService;
import com.zycus.boot.services.EventService;
import com.zycus.boot.services.LoginService;
import com.zycus.boot.services.SkillService;
import com.zycus.boot.services.UserService;
import com.zycus.enums.UserRole;

@Controller
@RequestMapping(path="/HRMS")
public class MainController {
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
	@Autowired
	LoginService loginService;
	
	@RequestMapping
	public String testUserService()
	{
		return "home";
	}
	
	@RequestMapping(path = "/log-in",method=RequestMethod.POST)
	public String logIn(HttpServletRequest httpServletRequest,Model model)
	{
		Integer id = Integer.parseInt(httpServletRequest.getParameter("username"));
		String password = httpServletRequest.getParameter("password");
		if(loginService.validateUser(id, password))
		{
			System.out.println("Authentication Successful");
			User user = userService.getUserById(id);
			loginService.setSessionFor(user, httpServletRequest.getSession());
			model.addAttribute("user",user);
			return moveToDashboard(user,model);
		}
		else
		{
			System.out.println("Authentication Failed");
			return moveToPage("error");
			
		}
	}
	public String moveToDashboard(User user,Model model)
	{
		if(user.getRole().equals(UserRole.HR))
		return "dashboard/hr";
		if(user.getRole().equals(UserRole.PANEL))
		return "dashboard/panel";
		else
		return "error";
	}
	public String moveToPage(String page)
	{
		return page;
	}

}
