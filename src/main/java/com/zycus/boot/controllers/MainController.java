package com.zycus.boot.controllers;

import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.zycus.helpers.Error;
import com.zycus.helpers.Message;
import com.zycus.helpers.Signal;

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
	public String logIn(HttpServletRequest httpServletRequest,Model model,HttpServletResponse response)
	{
		Integer id = Integer.parseInt(httpServletRequest.getParameter("username"));
		String password = httpServletRequest.getParameter("password");
		if(loginService.validateUser(id, password))
		{
			System.out.println("Authentication Successful");
			User user = userService.getUserById(id);
			loginService.setSessionFor(user, httpServletRequest.getSession());
			model.addAttribute("user",user);
			return moveToDashboard(user,model,response);
		}
		else
		{
			System.out.println("Authentication Failed");
			Signal signal = new Signal();
			signal.setMessage("Invalid Credentials Entered!");
			signal.setStatus(Signal.FAIL);
			model.addAttribute("message", signal);
			return "home";
			
		}
	}
	public String moveToDashboard(User user,Model model,HttpServletResponse response)
	{
		if(user.getRole().equals(UserRole.HR))
		return "dashboard/hr";
		if(user.getRole().equals(UserRole.PANEL))
		return "dashboard/panel";
		else
		{
			return "error";
		}
		
	}
	public String moveToPage(String page)
	{
		return page;
	}

}
