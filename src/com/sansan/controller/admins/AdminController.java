package com.sansan.controller.admins;

import java.security.MessageDigest;
import java.sql.ParameterMetaData;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sansan.BaseController;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.sansan.dao.Project;
import com.sansan.dao.User;
import com.sansan.service.UserService;

import org.springframework.web.servlet.RequestToViewNameTranslator;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;
import sun.security.util.Password;


/**
 * 用户管理实现类
 * @author Administrator
 * @date 2018-05-02
 */
@Controller
@RequestMapping("/admins")
public class AdminController extends BaseController{
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
		Integer page = request.getParameter("page")==null? 1:Integer.parseInt(request.getParameter("page"));//当前页
		Integer pageNum = request.getParameter("pageNum")==null ? 10:Integer.parseInt(request.getParameter("pageNum"));//每页数量
		Integer start = pageNum*(page-1);

		Integer end = pageNum;//获取记录条数

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start",start);
		map.put("end", end);

		List<User> user = userServ.getListAdmins(map);

		model.addAttribute("total",user.size());//总记录数
		model.addAttribute("page",page);//页数
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
			String userID = request.getParameter("userID");
			
			Map<String, Object> model = new HashMap<String,Object>();
			model.put("contextPath", contextPath);
			model.put("userID", userID);
			
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
	@RequestMapping("/addAndUpdateAdmin")
	public @ResponseBody Object addAndUpdateAdmin(HttpServletRequest request, Model model){
		try{
			int userID = ParameIsNull(request.getParameter("id"))? 0:Integer.parseInt(request.getParameter("id"));//用户ID
			String name  = request.getParameter("name");//姓名
			String passWord = request.getParameter("passWord");//密码，MD5加密密码
			String userName = request.getParameter("userName");//用户名
			int sex = ParameIsNull(request.getParameter("sex"))? -1:Integer.parseInt(request.getParameter("sex"));//性别 0:保密 1:女性 2:男性
			int age = ParameIsNull(request.getParameter("age"))? 0:Integer.parseInt(request.getParameter("age"));//年龄
			int positionID = ParameIsNull(request.getParameter("positionID"))? 0:Integer.parseInt(request.getParameter("positionID"));//职位ID
			String phone = request.getParameter("phone");//手机号码
			String address = request.getParameter("address");//地址


			if(ParameIsNull(name) || ParameIsNull(passWord) || ParameIsNull(userName) || sex==-1 || age==0 || positionID==0 || ParameIsNull("phone") || ParameIsNull(address)){
				model.addAttribute("msg", "must need other variables!");
				model.addAttribute("code", 1);
			}else{

				User user = new User();
				user.setUserID(userID);
				user.setName(name);
				user.setUserName(userName);
				user.setPassWord(passWord);
				user.setSex(sex);
				user.setAge(age);
				user.setPhone(phone);
				user.setAddress(address);
				user.setPositionID(positionID);

				if(userID == 0){//新增用户
					User userInfo = userServ.getUserID(userName);
					if(userInfo != null){
						model.addAttribute("msg","user is aready exit...");
						model.addAttribute("code",4);
					}else{
						int id = userServ.insertAdmin(user);//受影响记录条数
						if(id == 0){
							model.addAttribute("msg", "add error!");
							model.addAttribute("code", 2);
						}else{
							model.addAttribute("msg", "add success!");
							model.addAttribute("code", 3);
						}
					}
				}else{//编辑用户
					int uid = userServ.updateUserInfo(user);
					if(uid != 0){
						model.addAttribute("msg","update sucess...");
						model.addAttribute("code",5);
					}else {
						model.addAttribute("msg","update error...");
						model.addAttribute("code",6);
					}
				}
			}
		}catch(Exception e){
			log.info(e);
			model.addAttribute("code", 0);
			model.addAttribute("msg", "service error !");
		}
		return model;
	}

	/**
	 * 根据用户ID获取用户信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/getUserInfoByID")
	public @ResponseBody Object getUserInfoByID(HttpServletRequest request,Model model){
		try{
			int userID = ParameIsNull(request.getParameter("userID"))? 0:Integer.parseInt(request.getParameter("userID"));

			if(userID==0){
				model.addAttribute("msg","need must variable...");
				model.addAttribute("code","2");
			}else{
				List<User> user = userServ.getUserInfo(userID);
				model.addAttribute("data",user);
				model.addAttribute("msg","successs");
				model.addAttribute("code",1);
			}

		}catch (Exception e){
			log.info(e);
			model.addAttribute("msg","service error...");
			model.addAttribute("code",0);
		}
		return model;
	}

	/**
	 * 删除用户信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/delAdmins")
	public @ResponseBody Object delUserInfo(HttpServletRequest request,Model model){
		try{
			int userID = ParameIsNull(request.getParameter("userID"))? 0:Integer.parseInt(request.getParameter("userID"));

			if(userID==0){
				model.addAttribute("msg","neeed must variable...");
				model.addAttribute("code",2);
			}else {
				int uid = userServ.delUserInfo(userID);
				if (uid != 0) {
					model.addAttribute("msg", "del sucesss...");
					model.addAttribute("code", 1);
				}else{
					model.addAttribute("msg","del error...");
					model.addAttribute("code",3);
				}
			}
		}catch (Exception e){
			log.info(e);
			model.addAttribute("msg","service error....");
			model.addAttribute("code",0);
		}
		return model;
	}
}
