package com.sansan.mappers;

import java.util.List;
import java.util.Map;

import com.sansan.dao.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
    
    /**
     * 获取项目list
     * @param map
     * @return
     */
    List<Project> getProjectList(Map<String, Integer> map);
    /**
     * 获取项目总的记录条数
     * @return
     */
	int getProjectNumbers();
	
	/**
	 * 根据项目名称查找项目
	 * @param title
	 * @return
	 */
	Project getProjectByTitle(String title);
	
	/**
	 * 根据项目ID查找项目
	 * @param id
	 * @return
	 */
	Project getProjectById(String id);
}