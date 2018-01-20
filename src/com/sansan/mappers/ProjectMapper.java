package com.sansan.mappers;

import java.util.List;

import com.sansan.dao.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

	@SuppressWarnings("rawtypes")
	List getProjectList();
}