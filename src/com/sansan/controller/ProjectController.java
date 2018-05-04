package com.sansan.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sansan.dao.Project;
import com.sansan.dao.User;
import com.sansan.service.ProjectService;
import com.sansan.service.UserService;


/**
 * 项目管理实现类
 * @author Sisansan
 * @date 2018-05-02
 */

@Controller
@RequestMapping("/project")
public class ProjectController {
	// 日志记录
    private static final Logger log = Logger.getLogger(Project.class);
    
	@Autowired
	private ProjectService projectServ;
	
	@Autowired
	private UserService userServ;
	
	/**
	 * 跳转项目列表界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/view")
	public ModelAndView View(HttpServletRequest request){
		String contextpath = request.getContextPath();
		Map<String ,Object> model=new HashMap<String,Object>();
		 
		model.put("contextPath",contextpath);
		
		return new ModelAndView("Project/list",model);
	}
	
	/**
	 * 项目添加编辑页面跳转
	 * @param 
	 * @return
	 */
	@RequestMapping("/addAndUpdateView")
	public ModelAndView addAndUpdateView(HttpServletRequest request){
		String contextpath = request.getContextPath();
		Map<String ,Object> model=new HashMap<String,Object>();
		String id = request.getParameter("id");
		
		model.put("contextPath",contextpath);
		model.put("id", id);
		
		return new ModelAndView("Project/addAndUpdate",model);
	}
	
	/**
	 * 项目添加接口
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/insertProject")
	public @ResponseBody Object insertProject(HttpServletRequest request, Model model){
		try{
			String id = request.getParameter("id");
			System.out.println("+++++++++++++++"+id+"++++++++++++++++++++++");
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
			Date currentTime = new Date();
			
			String title = request.getParameter("title");//项目名称
			Integer principalID = 0;
			if(StringUtils.isNotEmpty(request.getParameter("principalID"))){
				principalID = Integer.parseInt(request.getParameter("principalID"));//负责人ID
			}
			String memberID = request.getParameter("memberID");//项目组成员ID
			
			Date startTime = StringUtils.isEmpty(request.getParameter("startTime"))?currentTime:format.parse(request.getParameter("startTime"));//项目开始时间
			Date endTime = StringUtils.isEmpty(request.getParameter("endTime"))?currentTime:format.parse(request.getParameter("endTime"));//项目结束时间
			
			String description = request.getParameter("description");//项目描述
			Integer status = 0;
			if(id.isEmpty()){//新增项目记录
				if(StringUtils.isEmpty(title)||principalID==0||StringUtils.isEmpty(memberID)||StringUtils.isEmpty(description)){
					model.addAttribute("code", 100);
					model.addAttribute("msg", "缺少必填参数！");
					return model;
				}else{
					Project project = new Project();
					project.setTitle(title);
					project.setPrincipalid(principalID);
					project.setMemberid(memberID);
					project.setStarttime(startTime);
					project.setEndtime(endTime);
					project.setDescription(description);
					project.setStatus(status);
					
					Project projectTwo = projectServ.getProjectByTitle(title);
					if(projectTwo != null){
						model.addAttribute("code", 102);
						model.addAttribute("msg", "项目已存在，请勿重复添加！");
					}else{
						projectServ.insertProject(project);
						model.addAttribute("code", 103);
						model.addAttribute("msg","项目添加成功！");
					}
				}
			}else{//编辑项目名称
				if(StringUtils.isEmpty(title)||principalID==0||StringUtils.isEmpty(memberID)||StringUtils.isEmpty(description)){
					model.addAttribute("code", 100);
					model.addAttribute("msg", "缺少必填参数！");
					return model;
				}else{
					Project project = new Project();
					project.setId(Integer.valueOf(id));
					project.setTitle(title);
					project.setPrincipalid(principalID);
					project.setMemberid(memberID);
					project.setStarttime(startTime);
					project.setEndtime(endTime);
					project.setDescription(description);
					project.setStatus(status);
					
					int update = projectServ.updateProject(project);
					if(update!=0){
						model.addAttribute("code", 104);
						model.addAttribute("msg", "项目编辑成功！");
					}else{
						model.addAttribute("code", 105);
						model.addAttribute("msg", "项目编辑失败！");
					}
				}
			}
				return model;
			
		}catch(Exception e){
			log.info(e);
			model.addAttribute("code", 101);
			model.addAttribute("msg", "服务器异常！");
			return model;
		}
		
	}
	/**
	 * 获取项目列表数据
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public @ResponseBody Object projectList(HttpServletRequest request, Model model){
		try{
			Integer page = request.getParameter("page")==null? 1:Integer.parseInt(request.getParameter("page"));//当前页
			Integer pageNum = request.getParameter("pageNum")==null ? 10:Integer.parseInt(request.getParameter("pageNum"));//每页数量
			Integer start = pageNum*(page-1);
			
			Integer end = pageNum;//获取记录条数
			
			Map<String,Integer> map = new HashMap<String,Integer>();
			map.put("start",start);
			map.put("end", end);
			//返回集合，集合里面的类需要定义
			List<Project> list = projectServ.getProjectList(map);
			
			//获取总的记录条数
			int total = projectServ.getProjectNumbers();
			
			String memberID="";
			String arr[]=new String[100];
			String memberName = "";
			String member = "";
			for(Project proList:list){
				System.out.print(proList.getMemberid());
				memberID = proList.getMemberid();
				//字符串分割为数组函数split
	            arr = memberID.split(",");
				for(int i=0;i<arr.length;i++){
				//获取用户姓名
				List<User>  user = userServ.getUserInfo(Integer.parseInt(arr[i]));
					for(User UserList:user){
						if(i == arr.length-1){
							memberName=UserList.getName();
						}else{
							memberName=UserList.getName()+",";
						}
					}
					member += memberName;
				}
				proList.setMembername(member);
				proList.setTotal(total);
				proList.setPage(page);
				System.out.print(member);
				member = "";
				
			}
			model.addAttribute("code", 100);
			model.addAttribute("data", list);
		}catch(Exception e){
			log.info(e);
			model.addAttribute("code", 101);
			model.addAttribute("msg", "异常！");
		}
		return model;
	}
	
	/**
	 * 获取项目总数接口
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/getCountProject")
	public @ResponseBody Object getCountProject(HttpServletRequest req, Model model){
		int projectCount = projectServ.getProjectNumbers();
		model.addAttribute("count", projectCount);
		return model;
	}
	
	/**
	 * 通过项目ID获取项目基本信息
	 * @param request id
	 * @param model {"data":{"id":1,"total":null,"description":"一款风靡全球的减压小游戏","status":0,"page":null,"title":"微信跳一跳小程序","principalid":1,"starttime":1516435605000,"endtime":1518682009000,"principalname":null,"membername":null,"memberid":"1,2"}}
	 * @return
	 */
	@RequestMapping("/getProjectInfoById")
	public @ResponseBody Object getProjectInfoById(HttpServletRequest request, Model model){
		String id = request.getParameter("id");
		Project project = projectServ.getProjectById(id);
		model.addAttribute("data", project);
		return model;
	}
	
	@RequestMapping("/delProject")
	public @ResponseBody Object delproject(HttpServletRequest request,	Model model){
		String id = request.getParameter("id");
		int delID = projectServ.delProject(Integer.valueOf(id));
		System.out.println(delID);
		if(delID != 0){
			model.addAttribute("code", 100);
			model.addAttribute("msg", "项目删除成功!");
		}else{
			model.addAttribute("code", 101);
			model.addAttribute("msg", "项目删除失败！");
		}
		return model;
	}
}
