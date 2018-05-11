package com.sansan.mappers;

import java.util.List;

import com.sansan.dao.Position;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer positionid);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer positionid);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

	List<Position> getAllPosition();
}