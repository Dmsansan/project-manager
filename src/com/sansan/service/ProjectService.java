package com.sansan.service;

import java.util.List;

public interface ProjectService {
	String SERVICE_NAME = "projectService";
	
	@SuppressWarnings("rawtypes")
	List getProjectList();


}
