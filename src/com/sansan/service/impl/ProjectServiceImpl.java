package com.sansan.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sansan.dao.Project;
import com.sansan.mappers.ProjectMapper;
import com.sansan.service.ProjectService;
@Transactional
@Service(ProjectService.SERVICE_NAME)
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectMapper projectMgr;
	
	/**
	 * 分页查询项目记录条数
	 */
	@Override
	public List<Project> getProjectList(Map<String, Integer> map) {
		return projectMgr.getProjectList(map);
	}
	
	/**
	 * 获取项目记录总的条数
	 */
	@Override
	public int getProjectNumbers() {
		return projectMgr.getProjectNumbers();
	}
	
	/**
	 * 新增项目
	 */
	@Override
	public int insertProject(Project project) {
		return projectMgr.insert(project);
	}
	
	/**
	 * 根据项目名称查找项目
	 */
	@Override
	public Project getProjectByTitle(String title) {
		return projectMgr.getProjectByTitle(title);
	}

}
