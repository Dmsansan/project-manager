package com.sansan.controller;


import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping("")
	public ModelAndView index(HttpRequest request){
		return new ModelAndView("System/register");
	}
	
	@RequestMapping("/login")
	public String login(){
		return "1313123";
	}
}
