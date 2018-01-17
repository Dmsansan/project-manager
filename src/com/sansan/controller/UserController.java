package com.sansan.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sansan.service.UserService;
import com.sansan.dao.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public @ResponseBody Object login(){
		List<User> user = userService.getUserInfo(1);
		if(user!=null){
			return user;
		}else{
			return "2313";
		}
		
	}
}
