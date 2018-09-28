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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/index")
	public ModelAndView testUserService()
	{
		return new ModelAndView("home");
	}
	@RequestMapping("sendToPage/{pageName}")
	public void sendToPage(@PathVariable("pageName") String pageName,HttpServletResponse response)
	{
		try {
			response.sendRedirect(pageName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@PostMapping(path = "/index")
	public ModelAndView logIn(HttpServletRequest httpServletRequest,ModelAndView modelAndView,HttpServletResponse response)
	{
		Integer id = Integer.parseInt(httpServletRequest.getParameter("username"));
		String password = httpServletRequest.getParameter("password");
		Map<String, Object> model = modelAndView.getModel();
		if(loginService.validateUser(id, password))
		{
			System.out.println("Authentication Successful");
			User user = userService.getUserById(id);
			loginService.setSessionFor(user, httpServletRequest.getSession());
			model.put("user",user);
			return new ModelAndView("redirect:dashboard");
		}
		else
		{
			System.out.println("Authentication Failed");
			Signal signal = new Signal();
			signal.setMessage("Invalid Credentials Entered!");
			signal.setStatus(Signal.FAIL);
			model.put("message", signal);
			return new ModelAndView("home",model);
			
		}
	}
	
	@RequestMapping(path="/dashboard")
	public ModelAndView moveToDashboard(HttpServletRequest httpServletRequest)
	{
		User user = loginService.getLoggedInUser(httpServletRequest.getSession());
		if(user.getRole().equals(UserRole.HR))
		return new ModelAndView("dashboard-user/index");
		if(user.getRole().equals(UserRole.PANEL))
		return new ModelAndView("dashboard-user/index");
		else
		{
			return new ModelAndView("error");
		}
		
	}
	public String moveToPage(String page)
	{
		return page;
	}

}
