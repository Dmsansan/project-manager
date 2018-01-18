package com.sansan.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sansan.dao.User;
import com.sansan.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// 日志记录
    private static final Logger log = Logger.getLogger(User.class);

	@Autowired
	private UserService userService;
	
	/**
	 * 用户登录验证
	 * @param request
	 * @param model
	 * @return	100：必填参数为空 101：用户不存在 102：输入的密码不正确 103：登录成功 104:异常
	 */
	@RequestMapping("/login")
	public @ResponseBody Object login(HttpServletRequest request, Model model){
		try{
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("passWord");
			String cheackBox = request.getParameter("cheackBox");
			
			//判断是否自动登录
			if(cheackBox.equals("true")){
				log.info("++++++++++++++"+cheackBox+"++++++++++++++++++++++");
				HttpSession session = request.getSession();
				session.setAttribute("isAutoLogin", cheackBox);
			}
			//判断输入参数是否为空
			if(this.isNULL(userName,passWord)){
				model.addAttribute("code", 100);
				model.addAttribute("msg", "必填参数为空！");
			}else{
				log.info("+++++++++++获取登录用户密码！+++++++++++");
				String passWordTwo = userService.getUserPassWord(userName);
				if(passWordTwo == null){//用户不存在
					model.addAttribute("code",101 );
					model.addAttribute("msg","用户不存在！");
				}else{
					log.info("++++++++++++登录用户的密码是：++++++++++++++"+passWordTwo+passWord);
					if(!passWord.equals(passWordTwo)){//密码不一致
						model.addAttribute("code", 102);
						model.addAttribute("msg", "输入的密码不正确！");
					}else{
						//登陆成功
						model.addAttribute("code", 103);
						model.addAttribute("msg", "登陆成功！");
					}
				}
			}
		}catch(Exception e){
			log.info(e);
			model.addAttribute("code", 104);
			model.addAttribute("msg", "异常！");
		}
		return model;
	}
	
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request){
		String contextpath = request.getContextPath();
		
		 Map<String ,Object> model=new HashMap<String,Object>();
		 
		 model.put("contextPath",contextpath);
		 return new ModelAndView("System/register",model);
	}
	
	/**
	 * 判断输入参数是否为空
	 * @param userName
	 * @param passWord
	 * @return 为空返回true 不为空返回false
	 */
	private boolean isNULL(String userName,String passWord) {
		if(userName == null || passWord == null){
			return true;
		}
		return false;
	}
}
