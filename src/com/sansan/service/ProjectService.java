package com.sansan.service;

import java.util.List;
import java.util.Map;

import com.sansan.dao.Project;

public interface ProjectService {
	String SERVICE_NAME = "projectService";
	
	List<Project> getProjectList(Map<String, Integer> map);

	int getProjectNumbers();
	
	int insertProject(Project project);

	Project getProjectByTitle(String title);

	Project getProjectById(String id);

	int updateProject(Project project);

	int delProject(Integer integer);


}
