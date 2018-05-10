package com.sansan.controller.admins;

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
	
}
