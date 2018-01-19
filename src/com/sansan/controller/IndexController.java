package com.sansan.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/index")
public class IndexController {
	
	@RequestMapping("")
	public ModelAndView index(HttpServletRequest request){
		
		String contextpath = request.getContextPath();
		
		Map<String ,Object> model=new HashMap<String,Object>();
		 
		model.put("contextPath",contextpath);
		return new ModelAndView("System/index",model);
	}
	
	@RequestMapping("/login")
	public String login(){
		return "1313123";
	}
}
