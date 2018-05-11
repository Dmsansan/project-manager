package com.sansan.service;

import java.util.List;

import com.sansan.dao.Position;

/**
 * 职位接口类
 * @author Administrator
 * @date 2018-05-11
 */
public interface PositionService {
	String SERVICE_NAME = "positionService";
	
	List<Position> getAllPosition();

}
