package com.sansan.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sansan.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Resource
	private ProjectService projectServ;
	
	/**
	 * 获取项目列表数据
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public @ResponseBody Object projectList(HttpServletRequest req, Model model){
		@SuppressWarnings("rawtypes")
		List list = projectServ.getProjectList();
		for(Object project:list){
			System.out.println(project);
		}
		model.addAttribute("code", 100);
		model.addAttribute("data", list);
		return model;
	}
}
