package com.sansan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sansan.mappers.ProjectMapper;
import com.sansan.service.ProjectService;
@Transactional
@Service(ProjectService.SERVICE_NAME)
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectMapper projectMgr;

	@SuppressWarnings("rawtypes")
	@Override
	public List getProjectList() {
		return projectMgr.getProjectList();
	}

}
