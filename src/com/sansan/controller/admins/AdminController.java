package com.sansan.controller.admins;

import java.security.MessageDigest;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sansan.dao.Project;
import com.sansan.dao.User;
import com.sansan.service.UserService;

import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;


/**
 * 用户管理实现类
 * @author Administrator
 * @date 2018-05-02
 */
@Controller
@RequestMapping("/admins")
public class AdminController {
	// 日志记录
    private static final Logger log = Logger.getLogger(Project.class);
    
    //用户service
	@Autowired
	private UserService userServ;
	/**
	 * 跳转至用户列表界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView AdminsList(HttpServletRequest request){
		String contextpath = request.getContextPath();
		Map<String, Object> model = new HashMap<String,Object>();
		System.out.println(contextpath+"+++++++++++++++");
		model.put("contextPath", contextpath);
		return new ModelAndView("admins/admins_list",model);
	}
	
	/**
	 * 获取用户列表数据
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/listData")
	public @ResponseBody Object listData(HttpServletRequest request, Model model){
		List<User> user = userServ.getListAdmins();
		
		model.addAttribute("data", user);
		model.addAttribute("msg", "获取用户列表数据！");
		return model;
	}
	
	/**
	 * 获取用户总数量
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/getCountAdmins")
	public @ResponseBody Object getCountAdmins(HttpServletRequest request, Model model){
		int count = userServ.getCountAdmins();
		model.addAttribute("count", count);
		return model;
	}
	
	/**
	 * 跳转用户添加编辑界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/addAndUpdateView")
	public ModelAndView addAndUpdateView(HttpServletRequest request){
		try{
			String contextPath = request.getContextPath();
			String id = request.getParameter("id");
			
			Map<String, Object> model = new HashMap<String,Object>();
			model.put("contextPath", contextPath);
			model.put("id", id);
			
			return new ModelAndView("admins/addAndUpdate",model);
		}catch(Exception e){
			log.info(e);
			return new ModelAndView("info/error");
		}
	}
	
	/**
	 * 新增或者编辑用户信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("insertAdmin")
	public @ResponseBody Object insertPosition(HttpServletRequest request, Model model){
		try{
			int userID = request.getParameter("id") == null? 0:Integer.parseInt(request.getParameter("id"));//用户ID
			String name  = request.getParameter("name");//姓名
			String passWord = request.getParameter("password");//密码，MD5加密密码
			String userName = request.getParameter("username");//用户名
			int sex = request.getParameter("sex") == null? 0:Integer.parseInt(request.getParameter("sex"));//性别
			int age = request.getParameter("age") == null? 0:Integer.parseInt(request.getParameter("age"));//年龄
			int positionID = request.getParameter("positionID") == null? 0:Integer.parseInt(request.getParameter("positionID"));//职位ID
			String phone = request.getParameter("phone");//手机号码
			String address = request.getParameter("address");//地址
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String date = df.format(new Date());
			
			User user = new User();
			
			if(name == null||name.equals("null") || passWord==null||passWord.equals("null") || userName==null||userName.equals("null")
					|| phone==null||phone.equals("null") || address==null||address.equals("null")
					){
				model.addAttribute("msg", "must need other variables!");
				model.addAttribute("code", 1);
			}else{
				//map.put("userID", userID);
				user.setName(name);
				user.setUserName(userName);
				user.setPassWord(passWord);
				user.setSex(sex);
				user.setAge(age);
				user.setPhone(phone);
				user.setAddress(address);
				user.setPositionID(positionID);
			}
			
			if(userID == 0){//新增用户
				int id = userServ.insertAdmin(user);
				if(id == 0){
					model.addAttribute("msg", "add error!");
					model.addAttribute("code", 2);
				}else{
					model.addAttribute("msg", "add success!");
					model.addAttribute("code", 3);
				}
			}else{//编辑用户
				model.addAttribute("msg", passWord);
			}
			
			
		}catch(Exception e){
			log.info(e);
			model.addAttribute("code", 0);
			model.addAttribute("msg", "service error !");
		}
		return model;
}
	
}
