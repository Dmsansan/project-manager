package com.sansan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sansan.dao.Position;
import com.sansan.mappers.PositionMapper;
import com.sansan.service.PositionService;
@Transactional
@Service(PositionService.SERVICE_NAME)
public class PositionServiceImpl implements PositionService{
	@Autowired
	private PositionMapper position;
	
	/**
	 * 获取职位列表 positionID name
	 */
	@Override
	public List<Position> getAllPosition() {
		List<Position> list = position.getAllPosition();
		return list;
	}
	
}
